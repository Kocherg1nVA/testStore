package com.teststore.model;

public enum Currency {
    EURO("Euro"),
    POUND("Pound Sterling"),
    DOLLAR("US Dollar");

    private final String displayName;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Currency fromString(String text) {
        for (Currency currency : Currency.values()) {
            if (currency.displayName.equalsIgnoreCase(text)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Валюта с названием: " + text + " не найдена");
    }
}
