package com.example.csye7374_group6.controller;

import com.example.csye7374_group6.dto.User;
import com.example.csye7374_group6.patterns.singleton.UserSingleton;
import com.example.csye7374_group6.patterns.template.PasswordAndEmailAuthentication;
import com.example.csye7374_group6.patterns.template.TwoFactorAuthentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> UserLogin(@RequestBody User user) {
        String username = user.getUsername();
        String userType = user.getUserType();
        String password = user.getPassword();
        String email = user.getEmail();
        String verificationCode = user.getVerificationCode();

        User userToLogin = new User.UserBuilder()
                .setUsername(username)
                .setUserType(userType)
                .setPassword(password)
                .setEmail(email)
                .setVerificationCode(verificationCode)
                .build();

        TwoFactorAuthentication auth = new PasswordAndEmailAuthentication();
        if (auth.isAuthenticated(userToLogin)) {
            UserSingleton currentUser = UserSingleton.getInstance();
            currentUser.setUsername(userToLogin.getUsername());
            currentUser.setUserType(userToLogin.getUserType());
            currentUser.setPassword(userToLogin.getPassword());
            currentUser.setEmail(userToLogin.getEmail());

            System.out.println("User logged in: " + currentUser.getUsername());
            return ResponseEntity.ok("Login successful, redirecting to products page.");
        } else {
            return ResponseEntity.badRequest().body("Invalid username, password, or verification code.");
        }
    }
}

