package com.example.mvvmapparch.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.mvvmapparch.R;
import com.example.mvvmapparch.model.Offer;

import java.util.List;

public class RecyclerViewOfferAdapter extends RecyclerView.Adapter<RecyclerViewOfferAdapter.MyViewHolder> {


    List<Offer> modelList;
    private static String IMG_URL = "http://techexactly.info/Clients/custom/barbuddy/uploads/";
    private int width, height;

    public RecyclerViewOfferAdapter(List<Offer> modelList, int width, int height) {
        this.modelList = modelList;
        this.width = width;
        this.height = height;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_near_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.barNameTv.setText(modelList.get(position).getBarName());
        holder.timeTv.setText(modelList.get(position).getDistance());
        holder.offertv.setText(modelList.get(position).getOfferName());
        holder.ratingTv.setText(modelList.get(position).getAvgRating());



       /*Picasso.get().load(IMG_URL+modelList.get(position).getMedia())
               .into(holder.imageView);*/

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView barNameTv, timeTv, offertv, ratingTv;
        ImageView imageView;
        LinearLayout linearLayout;
        public MyViewHolder(View v) {
            super(v);
            barNameTv = (TextView)v.findViewById(R.id.hotelSName);
            linearLayout = (LinearLayout)v.findViewById(R.id.mainLayout);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width/3,width/3-width/25);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setBackgroundColor(Color.WHITE);
            timeTv = (TextView)v.findViewById(R.id.timesTv);
            offertv = (TextView)v.findViewById(R.id.offerstv);
            ratingTv = (TextView)v.findViewById(R.id.ratingSTV);
            imageView = (ImageView)v.findViewById(R.id.imageView1);
            LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(width/3,width/5);
            imageView.setLayoutParams(imageViewParams);


        }
    }
}
