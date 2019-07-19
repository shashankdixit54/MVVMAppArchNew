package com.example.mvvmapparch;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvvmapparch.adapters.RecyclerViewAdapter;
import com.example.mvvmapparch.adapters.RecyclerViewOfferAdapter;
import com.example.mvvmapparch.model.Bar;
import com.example.mvvmapparch.model.Example;
import com.example.mvvmapparch.model.Offer;
import com.example.mvvmapparch.model.PopularOffer;
import com.example.mvvmapparch.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    RecyclerView.LayoutManager layoutManager, layoutManagerOffer;
    RecyclerView recyclerView, recyclerViewOffer;
    Example listItems;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerViewOfferAdapter recyclerViewOfferAdapter;
    LinearLayout popularOfferLayout;
    int width, height;
    TextView barNumTv;
    ImageView titleImageView;
    private SharedPreferences preferences;
    View popularOfferRow;

    MainActivityViewModel newsViewModel;

    List<Bar> barList;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getNetComponent().inject(this);


        width = getResources().getDisplayMetrics().widthPixels;
        height = getResources().getDisplayMetrics().heightPixels;
        preferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE);

        titleImageView = (ImageView) findViewById(R.id.titleImage);
        RelativeLayout.LayoutParams imageViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,height/6);
        titleImageView.setLayoutParams(imageViewParams);
        barNumTv = (TextView)findViewById(R.id.barNumTv);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        barList = new ArrayList<>();
        //setupRecyclerView();

        recyclerViewOffer = (RecyclerView)findViewById(R.id.recyclerViewOffer);
        layoutManagerOffer = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerViewOffer.setLayoutManager(layoutManagerOffer);;
        recyclerViewOffer.setHasFixedSize(true);

        popularOfferLayout = (LinearLayout)findViewById(R.id.cardViewForOffer);

        popularOfferRow = getLayoutInflater().inflate(R.layout.row_item,null);

        newsViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        newsViewModel.init(retrofit);
        newsViewModel.getdataRepository().observe(this, newsResponse -> {

            Example example = newsResponse;
            List<PopularOffer> popularOffer = example.getData().getPopularOffer();
            barList = example.getData().getBar();
            setPopularOfferLayout(popularOffer);
            barNumTv.setText(barList.size() +" Bars");
            Log.e("Bar List ",barList.size()+"");
            recyclerViewAdapter = new RecyclerViewAdapter(barList, width,height);
            recyclerView.setAdapter(recyclerViewAdapter);

            List<Offer> offer = example.getData().getOffer();
            Log.e("offer List ",offer.size()+"");
            recyclerViewOfferAdapter = new RecyclerViewOfferAdapter(offer,width,height);
            recyclerViewOffer.setAdapter(recyclerViewOfferAdapter);
        });

    }


    private void setPopularOfferLayout(List<PopularOffer> popularOffer){
        TextView barNameTv = (TextView)popularOfferRow.findViewById(R.id.barNameTv);
        barNameTv.setText(popularOffer.get(0).getBarName());
        TextView timeTv = (TextView)popularOfferRow.findViewById(R.id.timeTv);
        timeTv.setText(popularOffer.get(0).getDistance());
        TextView workingTimeTv = (TextView)popularOfferRow.findViewById(R.id.workTimeTv);
        workingTimeTv.setText(popularOffer.get(0).getOpenHour()+"-"+popularOffer.get(0).getCloseHour());
        TextView ratingTv = (TextView)popularOfferRow.findViewById(R.id.ratingTv);
        workingTimeTv.setText(popularOffer.get(0).getAvgRating());
        ImageView imageView = (ImageView)popularOfferRow.findViewById(R.id.hotelIv);
        /*Picasso.get().load(IMG_URL+popularOffer.get(0).getMedia())
                .into(imageView);*/
        imageView.setImageResource(R.drawable.alcohol_bar_beer_941864);
        popularOfferLayout.addView(popularOfferRow);
    }


/*
    private void setupRecyclerView() {

        if (recyclerViewAdapter == null) {
            recyclerViewAdapter = new RecyclerViewAdapter(barList, width,height);
            recyclerView.setAdapter(recyclerViewAdapter);
        }else {
            recyclerViewAdapter.notifyDataSetChanged();
        }




    }
*/
}
