package com.teststore.model;

public enum BackgroundColors {
    BLUE("rgba(0, 161, 203, 1)"),
    GREY("rgba(204, 204, 204, 1)");

    private final String colorCode;

    BackgroundColors(String colorCode){
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

}
