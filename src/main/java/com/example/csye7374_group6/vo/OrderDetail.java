package com.example.csye7374_group6.vo;

import com.example.csye7374_group6.dao.ProductDetail;
import com.example.csye7374_group6.dto.ProductDetailDTO;
import com.example.csye7374_group6.patterns.singleton.UserSingleton;
import com.example.csye7374_group6.patterns.strategy.DiscountStrategy;
import com.example.csye7374_group6.patterns.strategy.StudentDiscountStrategy;
import lombok.Data;

@Data
public class OrderDetail {
    ProductDetail productDetailDTO;
    DiscountStrategy discountStrategy;
    UserSingleton user;
    String address;
}
