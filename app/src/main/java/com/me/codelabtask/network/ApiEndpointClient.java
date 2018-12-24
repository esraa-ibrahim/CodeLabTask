package com.me.codelabtask.network;

import com.me.codelabtask.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiEndpointClient {
    private static ApiEndpointInterface instance;

    private ApiEndpointClient() {}

    public static ApiEndpointInterface newInstance() {
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            instance = retrofit.create(ApiEndpointInterface.class);
        }

        return instance;
    }
}
