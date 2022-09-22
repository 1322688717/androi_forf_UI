package com.example.androidui.main.bean;

import com.google.gson.annotations.SerializedName;

public class BeanLogin {

    @SerializedName("code")
    private String code;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
