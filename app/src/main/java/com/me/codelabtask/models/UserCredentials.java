package com.me.codelabtask.models;

import com.google.gson.annotations.SerializedName;

public class UserCredentials {
    @SerializedName("email")
    private String mEmail;

    @SerializedName("password")
    private String mPassword;

    public UserCredentials(String email, String password) {
        this.mEmail = email;
        this.mPassword = password;
    }
}
