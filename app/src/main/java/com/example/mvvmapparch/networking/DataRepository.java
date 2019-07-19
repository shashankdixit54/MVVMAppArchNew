package com.example.mvvmapparch.networking;


import android.arch.lifecycle.MutableLiveData;

import com.example.mvvmapparch.model.Example;

import javax.inject.Inject;

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

    public MutableLiveData<Example> getNews(String query1, String query2, String query3, String query4,
                                            String query5, String query6, String query7, String query8,
                                            String query9, String query10, String query11, String query12, String query13 ){
        final MutableLiveData<Example> newsData = new MutableLiveData<>();
        api.getData(query1, query2, query3, query4, query5, query6, query7, query8, query9,
                        query10, query11, query12,
                        query13 ).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call,
                                   Response<Example> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
