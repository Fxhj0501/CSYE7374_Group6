package com.example.csye7374_group6.patterns.command;

public class CommandInvoker {

    public void executeCommand(Command command) {
        command.execute();
    }
}

