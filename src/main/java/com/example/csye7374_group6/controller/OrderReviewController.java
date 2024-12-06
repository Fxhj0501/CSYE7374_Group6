package com.example.csye7374_group6.controller;

import com.example.csye7374_group6.dao.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderReviewController {
    @Autowired
    private PurchaseOrder purchaseOrder;
    @GetMapping("/getOrderReview")
    public PurchaseOrder getOrderReview() {
        return purchaseOrder;
    }
}
