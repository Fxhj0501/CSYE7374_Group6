package com.example.csye7374_group6.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDetail {
    String productName;
    Double price;
    String color;
    String storageSize;
    String serviceType;
    String bundleType;
}
