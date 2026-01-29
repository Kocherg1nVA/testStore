package com.teststore.utils;


import java.util.HashMap;
import java.util.Map;

public class ApiClientRouter {
    private static final Map<String, String> STATIC_PATHS = new HashMap<>();
    static {
        STATIC_PATHS.put("/v1/disk/", Stand.getUrl(Stand.ClientType.YANDEX));
        STATIC_PATHS.put("/booking", Stand.getUrl(Stand.ClientType.BOOKER));
    }
    //TODO добавить динамические пути

    public static String hostPath(String path) {
        for (Map.Entry<String, String> entry : STATIC_PATHS.entrySet()) {
            if (path.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        //TODO добавить логику для динамических путей
        return null;
    }

    /**
     * Добавляет новый путь для маршрутизации
     */
    public static void addRoute(String pathPrefix, Stand.ClientType clientType) {
        STATIC_PATHS.put(pathPrefix, Stand.getUrl(clientType));
    }

    /**
     * Добавляет новый путь с кастомным URL
     */
    public static void addRoute(String pathPrefix, String clientUrl) {
        STATIC_PATHS.put(pathPrefix, clientUrl);
    }
}
