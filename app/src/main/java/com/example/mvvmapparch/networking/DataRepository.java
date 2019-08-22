package com.example.mvvmapparch.networking;


import android.arch.lifecycle.MutableLiveData;

import com.example.mvvmapparch.model.NewsData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataRepository {

    private static DataRepository dataRepository;



    public static DataRepository getInstance(Retrofit retrofit){
        if (dataRepository == null){

            dataRepository = new DataRepository(retrofit);
        }
        return dataRepository;
    }

    private Api api;


    public DataRepository(Retrofit retrofit){
        api = retrofit.create(Api.class);
    }

    public MutableLiveData<NewsData> getNews(String query1, String query2, String query3){
        final MutableLiveData<NewsData> newsData = new MutableLiveData<>();
        api.getData(query1, query2, query3).enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call,
                                   Response<NewsData> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
