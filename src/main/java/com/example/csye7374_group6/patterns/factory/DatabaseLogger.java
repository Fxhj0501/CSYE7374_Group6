package com.example.csye7374_group6.patterns.factory;

import com.example.csye7374_group6.dao.PurchaseOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseLogger implements Logger {
    @Override
    public void log(PurchaseOrder po) {
        String url = "jdbc:mysql://localhost:3306/CSYE7374";
        String user = "root";
        String password = "password";

        String insertSQL = "INSERT INTO purchase_orders (userName, address, email, price) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, po.getUsername());
            preparedStatement.setString(2, po.getAddress());
            preparedStatement.setString(3, po.getEmail());
            preparedStatement.setDouble(4, po.getPrice());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("PurchaseOrder successfully logged to the database.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while logging PurchaseOrder: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
