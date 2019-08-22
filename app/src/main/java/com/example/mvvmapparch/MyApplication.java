package com.example.mvvmapparch;

import android.app.Application;

import com.example.mvvmapparch.daggers.ApiComponent;
import com.example.mvvmapparch.daggers.ApiModule;
import com.example.mvvmapparch.daggers.AppModule;
import com.example.mvvmapparch.daggers.DaggerApiComponent;

public class MyApplication extends Application {

    private ApiComponent mApiComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://newsapi.org/v2/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }

}
