package com.example.mvvmapparch.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mvvmapparch.model.Example;
import com.example.mvvmapparch.networking.DataRepository;

import retrofit2.Retrofit;


public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Example> mutableLiveData;
    private DataRepository dataRepository;

    public void init(Retrofit retrofit){
        if (mutableLiveData != null){
            return;
        }
        dataRepository = DataRepository.getInstance(retrofit);
        mutableLiveData = dataRepository.getNews("159","22.331460","88.348450","25","","","12345678","","","","","","");

    }

    public LiveData<Example> getdataRepository() {
        return mutableLiveData;
    }

}
