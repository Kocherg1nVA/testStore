package com.teststore.utils;

public class StepUtils {

    public static String resolve(String text) {
        return StorageUtils.resolveTemplate(text);
    }

    public static String resolve(String text, String defaultValue) {
        if (StorageUtils.containsVariable(text)) {
            return StorageUtils.resolveTemplate(text);
        }
        return text;
    }
}
