package com.example.csye7374_group6.patterns.decorator;

public class StorageSizeDecorator extends ProductDecorator{
    public StorageSizeDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getPrice() {
        // Adding logic to modify the price based on color attribute
        String storageSize = decoratedProduct.getStorageSize();

        System.out.println(storageSize);
        double additionalPrice = 0.0;

        switch (storageSize) {
            case "128GB":
                additionalPrice = 0.0; // Price increment for 128GB
                break;
            case "256GB":
                additionalPrice = 100.0; // Price increment for 256GB
                break;
            case "512GB":
                additionalPrice = 200.0; // Price increment for 512GB
                break;
            case "1TB":
                additionalPrice = 300.0; // Price increment for 1TB
                break;
            default:
                additionalPrice = 0.0; // Default increment
                break;
        }

        return decoratedProduct.getPrice() + additionalPrice;
    }
}
