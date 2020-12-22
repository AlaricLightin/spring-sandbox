package com.example.swaggerexperiment.controllers;

public class ErrorDto {
    private final int intField;

    public ErrorDto(int intField) {
        this.intField = intField;
    }

    public int getIntField() {
        return intField;
    }
}
