package com.example.csye7374_group6.patterns.state;

import com.example.csye7374_group6.dao.PurchaseOrder;

public interface OrderState {
    void next(PurchaseOrder order);
    void prev(PurchaseOrder order);
}
