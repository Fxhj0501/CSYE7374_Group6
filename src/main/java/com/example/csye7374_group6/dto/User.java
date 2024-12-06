package com.example.csye7374_group6.dto;

import lombok.Data;

@Data
public class User {
    String username;
    String userType;
    String password;
    String email;
    String verificationCode;
}
