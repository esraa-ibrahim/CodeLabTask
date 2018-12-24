package com.me.codelabtask.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    public int id;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("avatar")
    public String avatar;

    @Override
    public String toString() {
        return String.format("Id: %s\nFirst Name: %s\nLast Name: %s\nAvatar: %s", id, firstName, lastName, avatar);
    }
}
