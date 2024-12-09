package com.example.csye7374_group6.patterns.strategy;

public class DiscountContext {
    private DiscountStrategy discountStrategy;

    // 设置折扣策略
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // 计算最终价格
    public double getFinalPrice(double price) {
        if (discountStrategy == null) {
            throw new IllegalStateException("未设置折扣策略！");
        }
        return discountStrategy.calculateDiscount(price);
    }
}
