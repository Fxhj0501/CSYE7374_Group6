package com.example.csye7374_group6.patterns.state;

import com.example.csye7374_group6.dao.PurchaseOrder;

public class CreatedState implements OrderState {
    @Override
    public void next(PurchaseOrder order) {
        order.setState(new PaidState());
        System.out.println("Order is now paid.");
    }

    @Override
    public void prev(PurchaseOrder order) {
        System.out.println("The order is in its initial state.");
    }

    @Override
    public String toString() {
        return "Created";
    }
}


