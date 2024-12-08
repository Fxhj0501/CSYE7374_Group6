package com.example.csye7374_group6.dao;

import com.example.csye7374_group6.patterns.state.CreatedState;
import com.example.csye7374_group6.patterns.state.OrderState;
import com.fasterxml.jackson.annotation.JsonGetter;
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
    private OrderState state;

    public PurchaseOrder() {
        state = new CreatedState();
    }
    String productName;
    Double price;
    String username;
    String email;
    String address;
    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void prevState() {
        state.prev(this);
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "state=" + state.getClass().getSimpleName() + // 返回状态类名
                '}';
    }

    @JsonGetter("state")
    public String getStateName() {
        return state.toString();
    }
}
