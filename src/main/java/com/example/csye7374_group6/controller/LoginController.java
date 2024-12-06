package com.example.csye7374_group6.controller;

import com.example.csye7374_group6.dto.User;
import com.example.csye7374_group6.patterns.singleton.UserSingleton;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<String> UserLogin(@RequestBody User user) {
        if (user.getUsername() != null && user.getPassword() != null) {
            UserSingleton currentUser = UserSingleton.getInstance();
            currentUser.setUsername(user.getUsername());
            currentUser.setUserType(user.getUserType());
            currentUser.setPassword(user.getPassword());
            currentUser.setEmail(user.getEmail());

            System.out.println("User logged in: " + currentUser.getUsername());
            return ResponseEntity.ok("Login successful, redirecting to products page.");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        }
    }
}
