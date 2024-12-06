package com.example.csye7374_group6.patterns.template;

import com.example.csye7374_group6.dto.User;

public class PasswordAndSNSAuthentication extends TwoFactorAuthentication {
    @Override
    protected boolean verifyPrimaryFactor(User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return false;
        }

        // Skips the actual logic of validating user credentials...

        return true;
    }

    @Override
    protected boolean verifySecondaryFactor(User user) {
        if (user.getVerificationCode() == null || user.getVerificationCode().length() != 6) {
            return false;
        }

        // Skips the actual logic of validating dynamic verification code...

        return true;
    }
}
