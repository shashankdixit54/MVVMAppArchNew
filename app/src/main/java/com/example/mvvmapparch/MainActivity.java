package com.example.mvvmapparch;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.Toast;

import com.example.mvvmapparch.adapters.RecyclerViewAdapter;
import com.example.mvvmapparch.model.Article;
import com.example.mvvmapparch.model.NewsData;
import com.example.mvvmapparch.viewmodel.MainActivityViewModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    RecyclerViewAdapter recyclerViewAdapter;
    int width, height;
    private SharedPreferences preferences;

    MainActivityViewModel newsViewModel;
    SwipeRefreshLayout mSwipeRefreshLayout;


    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        Log.e("On Create "," Called");
        width = getResources().getDisplayMetrics().widthPixels;
        height = getResources().getDisplayMetrics().heightPixels;
        preferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);



        newsViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        if (isNetworkConnected()){
            setData();
        }else {
            Toast.makeText(MainActivity.this,"Internet Not Connected",Toast.LENGTH_SHORT).show();

        }


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
                if (isNetworkConnected()){
                    Toast.makeText(MainActivity.this,"Refreshing, Please Wait..",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this,"Internet Not Connected",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void setData(){

        newsViewModel.init(retrofit);
        newsViewModel.getdataRepository().observe(this, newsResponse -> {

            NewsData newsData = newsResponse;
            List<Article> articles = newsData.getArticles();

            recyclerViewAdapter = new RecyclerViewAdapter(articles, width,height);
            recyclerView.setAdapter(recyclerViewAdapter);

        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    @Override
    public boolean isFinishing() {
        Log.e("Is Finishing ",super.isFinishing()+"");
        return super.isFinishing();
    }

    @Override
    protected void onDestroy() {
        Log.e("On Destroy "," Called");
        super.onDestroy();
    }
}
