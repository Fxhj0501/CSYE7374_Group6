package com.example.csye7374_group6.controller;

import com.example.csye7374_group6.dao.ProductDetail;
import com.example.csye7374_group6.dao.PurchaseOrder;
import com.example.csye7374_group6.patterns.command.CheckoutCommand;
import com.example.csye7374_group6.patterns.command.CommandInvoker;
import com.example.csye7374_group6.patterns.command.OrderService;
import com.example.csye7374_group6.patterns.factory.Logger;
import com.example.csye7374_group6.patterns.factory.LoggerFactory;
import com.example.csye7374_group6.patterns.singleton.UserSingleton;
import com.example.csye7374_group6.patterns.strategy.*;
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

    private Logger fileLogger = LoggerFactory.createLogger("FILE");
    private final OrderService orderService;
    private final CommandInvoker invoker;

    @Autowired
    public PaymentController(OrderService orderService) {
        this.orderService = orderService;
        this.invoker = new CommandInvoker();
    }

    @GetMapping("/getOrderDetails")
    public OrderDetail showOrderDetails() {
        UserSingleton currentUser = UserSingleton.getInstance();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductDetailDTO(productDetail);
        orderDetail.setUser(currentUser);
        System.out.println(productDetail.getProductName());
        return orderDetail;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestBody OrderDetail orderDetail) {
        UserSingleton currentUser = UserSingleton.getInstance();
        DiscountContext discountContext = new DiscountContext();
        DiscountStrategy discountStrategy;
        switch (currentUser.getUserType()) {
            case "employee":
                discountStrategy = new EmployeeDiscountStrategy();
                break;
            case "user":
                System.out.println("asdasdasdasda");
                discountStrategy = new RegularUserDiscountStrategy();
                break;
            case "student":
                discountStrategy = new StudentDiscountStrategy();
                break;
            default:
                discountStrategy = new RegularUserDiscountStrategy();
        }
        discountContext.setDiscountStrategy(discountStrategy);
        purchaseOrder.setProductName(orderDetail.getProductDetailDTO().getProductName());
        purchaseOrder.setPrice(discountContext.getFinalPrice(orderDetail.getProductDetailDTO().getPrice()));
        purchaseOrder.setUsername(currentUser.getUsername());
        purchaseOrder.setAddress(orderDetail.getAddress());
        purchaseOrder.setEmail(currentUser.getEmail());
        purchaseOrder.nextState();

        fileLogger.log(purchaseOrder);

        invoker.executeCommand(new CheckoutCommand(orderService, purchaseOrder));

        return ResponseEntity.ok("Payment successful.");
    }
}
