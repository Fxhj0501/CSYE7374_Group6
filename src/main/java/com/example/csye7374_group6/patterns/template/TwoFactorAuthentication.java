package com.example.csye7374_group6.patterns.template;

import com.example.csye7374_group6.dto.User;

// Abstract class definition algorithm reconstruction
public abstract class TwoFactorAuthentication {
    // Template method: Define a fixed process for two-step verification
    public final boolean isAuthenticated(User user) {

        // Step 1: Basic information verification
        if (!verifyPrimaryFactor(user)) {
            return false;
        }
        // Step 2：Dynamic information verification
        if (!verifySecondaryFactor(user)) {
            return false;
        }

        return true;
    }

    protected abstract boolean verifyPrimaryFactor(User user);

    protected abstract boolean verifySecondaryFactor(User user);
}
