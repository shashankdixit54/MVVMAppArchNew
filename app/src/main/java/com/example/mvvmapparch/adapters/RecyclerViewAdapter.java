package com.example.mvvmapparch.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvvmapparch.R;
import com.example.mvvmapparch.model.Bar;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    List<Bar> modelList;
    private static String IMG_URL = "http://techexactly.info/Clients/custom/barbuddy/uploads/";
    private int width, height;

    public RecyclerViewAdapter(List<Bar> modelList, int width, int height) {
        this.modelList = modelList;
        this.width = width;
        this.height = height;
    }

    public void updateData(List<Bar> modelList){
        this.modelList =modelList;

        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.barNameTv.setText(modelList.get(position).getBarName());
        holder.timeTv.setText(modelList.get(position).getDistance());
        holder.workingTimeTv.setText(modelList.get(position).getOpenHour()+"-"+modelList.get(position).getCloseHour());
        holder.ratingTv.setText(modelList.get(position).getAvgRating());

       /* Picasso.get().load(IMG_URL+modelList.get(position).getMedia())
                .into(holder.imageView);*/


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView barNameTv, timeTv, workingTimeTv, ratingTv;
        ImageView imageView;
        public MyViewHolder(View v) {
            super(v);
            barNameTv = (TextView)v.findViewById(R.id.barNameTv);
            timeTv = (TextView)v.findViewById(R.id.timeTv);
            workingTimeTv = (TextView)v.findViewById(R.id.workTimeTv);
            ratingTv = (TextView)v.findViewById(R.id.ratingTv);
            imageView = (ImageView)v.findViewById(R.id.hotelIv);


        }
    }
}
