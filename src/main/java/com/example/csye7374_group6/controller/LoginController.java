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
        // Different verification template implementation classes are used according to the needs of the users.
        // Here we simply use a default template.
        TwoFactorAuthentication auth = new PasswordAndEmailAuthentication();
        if (auth.isAuthenticated(user)) {
            UserSingleton currentUser = UserSingleton.getInstance();
            currentUser.setUsername(user.getUsername());
            currentUser.setUserType(user.getUserType());
            currentUser.setPassword(user.getPassword());
            currentUser.setEmail(user.getEmail());

            System.out.println("User logged in: " + currentUser.getUsername());
            return ResponseEntity.ok("Login successful, redirecting to products page.");
        } else {
            return ResponseEntity.badRequest().body("Invalid username, password, or email verification code.");
        }
    }
}
