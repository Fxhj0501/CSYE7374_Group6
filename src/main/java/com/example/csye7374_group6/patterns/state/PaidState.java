package com.example.csye7374_group6.patterns.state;

import com.example.csye7374_group6.dao.PurchaseOrder;

public class PaidState implements OrderState {
    @Override
    public void next(PurchaseOrder order) {
        System.out.println("Order is now shipped.");
    }

    @Override
    public void prev(PurchaseOrder order) {
        order.setState(new CreatedState());
        System.out.println("Order is back to created state.");
    }

    @Override
    public String toString() {
        return "Paid";
    }
}

