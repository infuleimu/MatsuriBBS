package com.example.matsuribbsandroid.service;

import com.example.matsuribbsandroid.login.LoginResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatsuriBBSManager {
    private static MatsuriBBSService matsuriBBSService;

    private static Retrofit createRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(matsuriBBSService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public synchronized static MatsuriBBSService createOpenApiService(){
        if(matsuriBBSService == null){
            Retrofit retrofit = createRetrofit();
            matsuriBBSService =retrofit.create(MatsuriBBSService.class);
        }
        return matsuriBBSService;
    }


}
