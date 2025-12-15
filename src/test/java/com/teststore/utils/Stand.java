package com.teststore.utils;

import com.teststore.config.Config;

public class Stand {
    public static final String YANDEX;
    public static final String BOOKER;

    static {
        YANDEX = Config.getYandexApiBaseUrl();
        BOOKER = Config.getBookerApiBaseUrl();
    }

}
