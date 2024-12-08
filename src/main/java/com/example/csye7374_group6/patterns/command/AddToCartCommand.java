package com.example.csye7374_group6.patterns.command;

import com.example.csye7374_group6.dao.ProductDetail;

public class AddToCartCommand implements Command {
    private final OrderService orderService;
    private final ProductDetail productDetail;
    public AddToCartCommand(OrderService orderService, ProductDetail productDetail) {
        this.orderService = orderService;
        this.productDetail = productDetail;
    }

    @Override
    public void execute() {
        orderService.addItemToOrder(productDetail);
    }
}

