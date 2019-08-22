package com.example.mvvmapparch.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.mvvmapparch.model.NewsData;
import com.example.mvvmapparch.networking.DataRepository;

import retrofit2.Retrofit;


public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<NewsData> mutableLiveData;
    private DataRepository dataRepository;

    public void init(Retrofit retrofit){
        if (mutableLiveData != null){
            return;
        }
        dataRepository = DataRepository.getInstance(retrofit);
        mutableLiveData = dataRepository.getNews("in","business","9b64bcfe576047ba8e5bb7fd24c9e526");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("View Model ","Cleared");
    }

    public MainActivityViewModel() {
        super();
        Log.e("View Model : ","Created");
    }

    public LiveData<NewsData> getdataRepository() {
        return mutableLiveData;
    }

}
