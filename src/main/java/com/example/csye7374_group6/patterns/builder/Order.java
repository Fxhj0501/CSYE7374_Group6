package com.example.csye7374_group6.patterns.builder;

import org.springframework.stereotype.Component;

public class Order {
    private final String productName;
    private final double price;
    private final String color;
    private final String storageSize;
    private final String serviceType;
    private final String bundleType;

    // 私有构造函数
    private Order(OrderBuilder builder) {
        this.productName = builder.productName;
        this.price = builder.price;
        this.color = builder.color;
        this.storageSize = builder.storageSize;
        this.serviceType = builder.serviceType;
        this.bundleType = builder.bundleType;
    }

    // Getters
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getBundleType() {
        return bundleType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", storageSize='" + storageSize + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", bundleType='" + bundleType + '\'' +
                '}';
    }

    // 静态内部 Builder 类
    public static class OrderBuilder {
        private String productName;
        private double price;
        private String color;
        private String storageSize;
        private String serviceType;
        private String bundleType;

        // Setter 方法返回 Builder 本身
        public OrderBuilder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public OrderBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public OrderBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public OrderBuilder setStorageSize(String storageSize) {
            this.storageSize = storageSize;
            return this;
        }

        public OrderBuilder setServiceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public OrderBuilder setBundleType(String bundleType) {
            this.bundleType = bundleType;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
