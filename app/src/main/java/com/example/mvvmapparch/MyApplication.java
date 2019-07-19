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
                .apiModule(new ApiModule("https://navkiraninfotech.com/Customers/custom/barbuddy/api/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }

}
