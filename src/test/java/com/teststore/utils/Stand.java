package com.teststore.utils;

import com.teststore.config.Config;

import java.util.HashMap;
import java.util.Map;

public class Stand {

    public enum ClientType {
        YANDEX,
        BOOKER
    }

    private static final Map<ClientType, String> CLIENT_URLS = new HashMap<>();

    static {
        loadUrlsFromConfig();
    }

    private static void loadUrlsFromConfig() {
        CLIENT_URLS.put(ClientType.YANDEX, Config.getYandexApiBaseUrl());
        CLIENT_URLS.put(ClientType.BOOKER, Config.getBookerApiBaseUrl());
    }

    public static String getUrl(ClientType clientType) {
        String url = CLIENT_URLS.get(clientType);
        if (url == null) {
            throw new IllegalArgumentException("URL не найден для клиента: " + clientType);
        }
        return url;
    }

    public static ClientType getClientTypeByUrl(String url) {
        return CLIENT_URLS.entrySet().stream()
                .filter(entry -> url.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Неизвестный URL: " + url));
    }

    public static boolean isYandexUrl(String url) {
        return url.equals(getUrl(ClientType.YANDEX));
    }

    public static boolean isBookerUrl(String url) {
        return url.equals(getUrl(ClientType.BOOKER));
    }

    public static boolean containsUrl(String url) {
        return CLIENT_URLS.containsValue(url);
    }

    public static void reloadUrls() {
        CLIENT_URLS.clear();
        loadUrlsFromConfig();
    }
}
