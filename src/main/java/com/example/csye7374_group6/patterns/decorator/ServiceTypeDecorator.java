package com.example.csye7374_group6.patterns.decorator;

public class ServiceTypeDecorator extends ProductDecorator{
    public ServiceTypeDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getPrice() {
        // Adding logic to modify the price based on color attribute
        String serviceType = decoratedProduct.getServiceType();

        System.out.println(serviceType);
        double additionalPrice = 0.0;

        switch (serviceType) {
            case "Standard Warranty":
                additionalPrice = 0.0; // Price increment for 128GB
                break;
            case "AppleCare+":
                additionalPrice = 100.0; // Price increment for 256GB
                break;
            default:
                additionalPrice = 0.0; // Default increment
                break;
        }

        return decoratedProduct.getPrice() + additionalPrice;
    }
}
