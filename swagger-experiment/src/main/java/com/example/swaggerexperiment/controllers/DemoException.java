package com.example.swaggerexperiment.controllers;

public class DemoException extends Exception{
    private final int intField;

    public DemoException(int intField) {
        this.intField = intField;
    }

    public int getIntField() {
        return intField;
    }
}
