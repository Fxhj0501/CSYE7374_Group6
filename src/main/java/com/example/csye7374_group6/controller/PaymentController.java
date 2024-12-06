package com.example.csye7374_group6.controller;

import com.example.csye7374_group6.dao.ProductDetail;
import com.example.csye7374_group6.dao.PurchaseOrder;
import com.example.csye7374_group6.dto.ProductDetailDTO;
import com.example.csye7374_group6.patterns.singleton.UserSingleton;
import com.example.csye7374_group6.vo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private ProductDetail productDetail;
    @Autowired
    private PurchaseOrder purchaseOrder;
    @GetMapping("/getOrderDetails")
    public OrderDetail showOrderDetails() {
        UserSingleton currentUser = UserSingleton.getInstance();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductDetailDTO(productDetail);
        orderDetail.setDiscountStrategy(null);
        orderDetail.setUser(currentUser);
        System.out.println(productDetail.getProductName());
        return orderDetail;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestBody OrderDetail orderDetail){
        UserSingleton currentUser = UserSingleton.getInstance();
        purchaseOrder.setProductName(orderDetail.getProductDetailDTO().getProductName());
        purchaseOrder.setPrice(orderDetail.getProductDetailDTO().getPrice());
        purchaseOrder.setPrice(orderDetail.getProductDetailDTO().getPrice());
        purchaseOrder.setUsername(currentUser.getUsername());
        purchaseOrder.setAddress(orderDetail.getAddress());
        purchaseOrder.setEmail(currentUser.getEmail());
        System.out.println(purchaseOrder.getAddress());
        return ResponseEntity.ok("Payment successful.");
    }
}
