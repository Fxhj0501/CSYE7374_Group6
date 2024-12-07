package com.example.csye7374_group6.patterns.factory;

public class LoggerFactory {
    public static Logger createLogger(String type) {
        if ("CONSOLE".equalsIgnoreCase(type)) {
            return new ConsoleLogger();
        } else if ("FILE".equalsIgnoreCase(type)) {
            return new FileLogger();
        } else if ("DATABASE".equalsIgnoreCase(type)) {
            return new DatabaseLogger();
        } else {
            throw new IllegalArgumentException("Unknown Type: " + type);
        }
    }
}

