package com.me.codelabtask.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersData {
    @SerializedName("data")
    public List<User> userList;
}
