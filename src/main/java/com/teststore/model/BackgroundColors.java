package com.teststore.model;

import io.cucumber.java.uz.Бирок;

public enum BackgroundColors {
    BLUE("rgba(0, 161, 203, 1)"),
    VIOLET("rgba(59, 0, 73, 1)"),
    GREY("rgba(204, 204, 204, 1)"),
    GREEN("rgba(223, 240, 216, 1)");

    private final String colorCode;

    BackgroundColors(String colorCode){
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

}
