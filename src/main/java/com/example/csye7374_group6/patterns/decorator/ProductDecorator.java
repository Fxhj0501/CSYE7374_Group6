package com.example.csye7374_group6.patterns.decorator;

public class ProductDecorator implements Product{
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public String getProductName() {
        return decoratedProduct.getProductName();
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }

    @Override
    public String getColor() {
        return decoratedProduct.getColor();
    }

    @Override
    public String getStorageSize() {
        return decoratedProduct.getStorageSize();
    }

    @Override
    public String getServiceType() {
        return decoratedProduct.getServiceType();
    }

    @Override
    public String getBundleType() {
        return decoratedProduct.getBundleType();
    }


}
