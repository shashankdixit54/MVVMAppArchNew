package com.example.mvvmapparch.networking;

import com.example.mvvmapparch.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    @Headers({"Content-Type:application/json"})
    @POST("get_home_content")
    Call<Example> getData(@Query("user_id") String query1,
                          @Query("latitude") String query2,
                          @Query("longitude") String query3,
                          @Query("distance") String query4,
                          @Query("type") String query5,
                          @Query("rating") String query6,
                          @Query("device_token") String query7,
                          @Query("is_live_music") String query8,
                          @Query("is_happy_hour") String query9,
                          @Query("is_special_food") String query10,
                          @Query("is_smoking_bar") String query11,
                          @Query("event_type") String query12,
                          @Query("event_date") String query13

    );

}
