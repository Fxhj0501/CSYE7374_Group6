package com.example.csye7374_group6.patterns.command;

import com.example.csye7374_group6.dao.ProductDetail;
import com.example.csye7374_group6.dao.PurchaseOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void addItemToOrder(ProductDetail productDetail) {
        System.out.println("Performed Order detail");
    }

    public void checkoutOrder(PurchaseOrder purchaseOrder) {
        System.out.println("Performed Order pay");
    }
}

