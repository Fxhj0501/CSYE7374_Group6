package com.example.csye7374_group6.patterns.decorator;

public class BundleTypeDecorator extends ProductDecorator{
    public BundleTypeDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getPrice() {
        // Adding logic to modify the price based on color attribute
        String bundleType = decoratedProduct.getBundleType();

        System.out.println(bundleType);
        double additionalPrice = 0.0;

        switch (bundleType) {
            case "Standard Package":
                additionalPrice = 0.0; // Price increment for 128GB
                break;
            case "Premium Package":
                additionalPrice = 100.0; // Price increment for 256GB
                break;
            default:
                additionalPrice = 0.0; // Default increment
                break;
        }

        return decoratedProduct.getPrice() + additionalPrice;
    }
}
