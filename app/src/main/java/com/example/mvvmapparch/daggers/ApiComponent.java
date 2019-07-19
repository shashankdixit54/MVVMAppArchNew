package com.example.mvvmapparch.daggers;

import com.example.mvvmapparch.MainActivity;
import com.example.mvvmapparch.networking.DataRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);

}
