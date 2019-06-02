package com.strikalov.serverhw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarPogo {

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "AvatarPogo{" +
                "avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
