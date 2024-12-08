package com.example.csye7374_group6.patterns.decorator;

public class BasicProduct implements Product{
    private String productName;
    private double price;
    private String color;
    private String storageSize;
    private String serviceType;
    private String bundleType;

    public BasicProduct(String productName, double price, String color, String storageSize, String serviceType, String bundleType) {
        this.productName = productName;
        this.price = price;
        this.color = color;
        this.storageSize = storageSize;
        this.serviceType = serviceType;
        this.bundleType = bundleType;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getStorageSize() {
        return storageSize;
    }

    @Override
    public String getServiceType() {
        return serviceType;
    }

    @Override
    public String getBundleType() {
        return bundleType;
    }
}
