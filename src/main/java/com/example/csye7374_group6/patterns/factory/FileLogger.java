package com.example.csye7374_group6.patterns.factory;

import com.example.csye7374_group6.dao.PurchaseOrder;

import java.io.*;

public class FileLogger implements Logger {
    @Override
    public void log(PurchaseOrder po) {
        String filePath = "./src/main/java/com/example/csye7374_group6/log/log.txt";
        File logFile = new File(filePath);
        logFile.getParentFile().mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // `true` 表示追加写入
            writer.write("Purchase Order Log:");
            writer.newLine();
            writer.write("Username: " + po.getUsername());
            writer.newLine();
            writer.write("Address: " + po.getAddress());
            writer.newLine();
            writer.write("Email: " + po.getEmail());
            writer.newLine();
            writer.write("ProductName: " + po.getProductName());
            writer.newLine();
            writer.write("Price: " + po.getPrice());
            writer.newLine();

            writer.write("------------------------------");
            writer.newLine();
            System.out.println("The log has been written to the file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
