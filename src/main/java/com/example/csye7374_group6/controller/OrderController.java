package com.example.csye7374_group6.controller;

import com.example.csye7374_group6.dao.ProductDetail;
import com.example.csye7374_group6.dto.ProductDetailDTO;
import com.example.csye7374_group6.patterns.builder.Order;
import com.example.csye7374_group6.patterns.command.AddToCartCommand;
import com.example.csye7374_group6.patterns.command.CommandInvoker;
import com.example.csye7374_group6.patterns.command.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private ProductDetail productDetail;
    private final OrderService orderService;
    private final CommandInvoker invoker;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.invoker = new CommandInvoker();
    }
    @PostMapping("/productDetail")
    public ResponseEntity<String> takeOrder(@RequestBody ProductDetailDTO productDetailDTO) {
        this.productDetail.setProductName(productDetailDTO.getProductName());
        this.productDetail.setPrice(productDetailDTO.getPrice());
        this.productDetail.setColor(productDetailDTO.getColor());
        this.productDetail.setStorageSize(productDetailDTO.getStorageSize());
        this.productDetail.setServiceType(productDetailDTO.getServiceType());
        this.productDetail.setBundleType(productDetailDTO.getBundleType());
        System.out.println(this.productDetail.getProductName());
        Order order = new Order.OrderBuilder()
                .setProductName(productDetailDTO.getProductName())
                .setPrice(productDetailDTO.getPrice())
                .setColor(productDetailDTO.getColor())
                .setStorageSize(productDetailDTO.getStorageSize())
                .setServiceType(productDetailDTO.getServiceType())
                .setBundleType(productDetailDTO.getBundleType())
                .build();
        System.out.println(order.toString());
        invoker.executeCommand(new AddToCartCommand(orderService, this.productDetail));
        return ResponseEntity.ok("Order placed successfully.");
    }
}
