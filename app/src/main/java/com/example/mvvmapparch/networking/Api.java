package com.example.mvvmapparch.networking;

import com.example.mvvmapparch.model.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    @Headers({"Content-Type:application/json"})
    @GET("top-headlines")
    Call<NewsData> getData(@Query("country") String countryName,
                           @Query("category") String categoryName,
                           @Query("apiKey") String apiKey
    );

}
