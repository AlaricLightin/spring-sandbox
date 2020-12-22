package com.example.swaggerexperiment.controllers;

public class ResultDto {
    private final int intField;

    public ResultDto(int intField) {
        this.intField = intField;
    }

    public int getIntField() {
        return intField;
    }
}
