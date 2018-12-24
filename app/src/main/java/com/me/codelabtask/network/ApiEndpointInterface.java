package com.me.codelabtask.network;

import com.me.codelabtask.models.Token;
import com.me.codelabtask.models.UserCredentials;
import com.me.codelabtask.models.UsersData;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiEndpointInterface {
    @Headers("Content-Type: application/json")
    @POST("api/register")
    Observable<Token> login(@Body UserCredentials credentials);

    @GET("api/users?page=1")
    Observable<UsersData> getUserList();
}
