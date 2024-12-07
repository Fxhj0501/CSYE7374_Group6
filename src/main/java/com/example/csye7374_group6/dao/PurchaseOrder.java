package com.example.csye7374_group6.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@Setter
@Getter
public class PurchaseOrder implements Serializable {
    String productName;
    Double price;
    String username;
    String email;
    String address;

}
