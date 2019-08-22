package com.example.mvvmapparch.adapters;

import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvvmapparch.R;
import com.example.mvvmapparch.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    List<Article> modelList;
    private int width, height;

    public RecyclerViewAdapter(List<Article> modelList, int width, int height) {
        this.modelList = modelList;
        this.width = width;
        this.height = height;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.titleTv.setText(modelList.get(position).getTitle());


        Picasso.get().load(modelList.get(position).getUrlToImage())
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleTv;
        ImageView imageView;
        public MyViewHolder(View v) {
            super(v);
            titleTv = (TextView)v.findViewById(R.id.titleTv);
            titleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, width/70);
            imageView = (ImageView)v.findViewById(R.id.hotelIv);
            imageView.getLayoutParams().width = width/4;
            imageView.getLayoutParams().height = width/4;
        }
    }
}
