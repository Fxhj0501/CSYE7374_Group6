package com.example.csye7374_group6.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@Setter
@Getter
public class PurchaseOrder {
    String productName;
    Double price;
    String username;
    String email;
    String address;

}
