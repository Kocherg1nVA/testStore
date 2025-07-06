package com.teststore.config;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(Config.class.getClassLoader()
                    .getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке конфигурации из файла config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url");
    }

    public static String getLoginUrl() {
        return PROPERTIES.getProperty("login.url");
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("browser");
    }

    public static String getTimeOut() {
        return PROPERTIES.getProperty("timeout");
    }

    public static String getBrowserResolution() {
        return PROPERTIES.getProperty("browserResolution");
    }

    public static String getBrowserPosition() {
        return PROPERTIES.getProperty("browserPosition");
    }

    public static String getLogin() {
        return PROPERTIES.getProperty("auth.login");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("auth.password");
    }
}
