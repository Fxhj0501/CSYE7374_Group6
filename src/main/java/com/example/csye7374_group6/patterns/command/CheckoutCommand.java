package com.example.csye7374_group6.patterns.command;

import com.example.csye7374_group6.dao.PurchaseOrder;

public class CheckoutCommand implements Command {
    private final OrderService orderService;
    private final PurchaseOrder purchaseOrder;

    public CheckoutCommand(OrderService orderService, PurchaseOrder purchaseOrder) {
        this.orderService = orderService;
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public void execute() {
        orderService.checkoutOrder(purchaseOrder);
    }
}

