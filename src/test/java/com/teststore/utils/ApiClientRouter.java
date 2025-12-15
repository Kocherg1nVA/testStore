package com.teststore.utils;


import java.util.HashMap;
import java.util.Map;

public class ApiClientRouter {
    private static final Map<String, String> STATIC_PATHS = new HashMap<>();
    static {
        STATIC_PATHS.put("/v1/disk/", Stand.YANDEX);
        STATIC_PATHS.put("/booking", Stand.BOOKER);
    }
    //TODO добавить динамические пути

    public static String hostPath(String path) {
        if (STATIC_PATHS.containsKey(path)) {
            return STATIC_PATHS.get(path);
        }
        return null;
    }
}
