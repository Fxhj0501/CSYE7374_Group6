package com.example.csye7374_group6.dto;

import lombok.Data;

@Data
public class User {
    private String username;
    private String userType;
    private String password;
    private String email;
    private String verificationCode;

    public static class UserBuilder {
        private String username;
        private String userType;
        private String password;
        private String email;
        private String verificationCode;

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setUserType(String userType) {
            this.userType = userType;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUsername(this.username);
            user.setUserType(this.userType);
            user.setPassword(this.password);
            user.setEmail(this.email);
            user.setVerificationCode(this.verificationCode);
            return user;
        }
    }
}

