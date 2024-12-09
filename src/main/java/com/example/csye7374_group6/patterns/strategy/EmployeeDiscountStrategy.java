package com.example.csye7374_group6.patterns.strategy;

public class EmployeeDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        return originalPrice * 0.85;
    }
}