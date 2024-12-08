package com.example.csye7374_group6.patterns.decorator;

public class ColorDecorator extends ProductDecorator{
    public ColorDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getPrice() {
        // Adding logic to modify the price based on color attribute
        String color = decoratedProduct.getColor();

        System.out.println(color);
        double additionalPrice = 0.0;

        switch (color) {
            case "Natural Titanium":
                additionalPrice = 0.0; // Price increment for Natural Titanium
                break;
            case "Black Titanium":
                additionalPrice = 200.0; // Price increment for Black Titanium
                break;
            case "Sand Titanium":
                additionalPrice = 300.0; // Price increment for Sand Titanium
                break;
            case "White Titanium":
                additionalPrice = 400.0; // Price increment for White Titanium
                break;
            default:
                additionalPrice = 0.0; // Default increment if color is not recognized
                break;
        }

        return decoratedProduct.getPrice() + additionalPrice;
    }
}
