package com.me.codelabtask.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiEndpointClient {
    private static ApiEndpointInterface instance;

    private ApiEndpointClient() {}

    public static ApiEndpointInterface newInstance() {
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://reqres.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            instance = retrofit.create(ApiEndpointInterface.class);
        }

        return instance;
    }
}
