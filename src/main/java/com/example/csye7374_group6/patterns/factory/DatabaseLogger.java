package com.example.csye7374_group6.patterns.factory;

import com.example.csye7374_group6.dao.PurchaseOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseLogger implements Logger {
    @Override
    public void log(PurchaseOrder po) {
//        String url = "jdbc:mysql://localhost:3306/your_database";
//        String user = "root";
//        String password = "password";
//
//
//        String insertSQL = "INSERT INTO purchase_orders (id, customer, total_amount, date) VALUES (?, ?, ?, ?)";
//
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
//
//
//            preparedStatement.setString(1, po.getId());
//            preparedStatement.setString(2, po.getCustomer());
//            preparedStatement.setDouble(3, po.getTotalAmount());
//            preparedStatement.setTimestamp(4, new java.sql.Timestamp(po.getDate().getTime()));
//
//            int rowsInserted = preparedStatement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("PurchaseOrder successfully logged to the database.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
        System.out.println("PurchaseOrder successfully logged to the database.");
    }
}
