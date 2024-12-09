package com.example.csye7374_group6.patterns.singleton;

import com.example.csye7374_group6.patterns.strategy.*;
import lombok.Data;

public class UserSingleton {

    private static UserSingleton instance;

    private String username;
    private String userType;
    private String password;
    private String email;

    private UserSingleton() {}

    public static synchronized UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public DiscountStrategy getDiscountStrategy() {

    }
}
