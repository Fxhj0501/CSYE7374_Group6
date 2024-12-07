package com.example.csye7374_group6.patterns.factory;

import com.example.csye7374_group6.dao.PurchaseOrder;

// 控制台日志
public class ConsoleLogger implements Logger {
    @Override
    public void log(PurchaseOrder po) {
        System.out.println("The log has been output to the console： " + po);
    }
}

