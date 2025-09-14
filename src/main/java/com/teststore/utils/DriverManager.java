package com.teststore.utils;

import java.nio.file.Paths;

public class DriverManager {

    public static String getDriverPath() {
        String os = System.getProperty("os.name").toLowerCase();
        String driverName = "chromedriver";

        if (os.contains("win")) {
            driverName = "chromedriver.exe";
            return Paths.get("src", "test",
                    "resources", "drivers", "windows", driverName).toAbsolutePath().toString();
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return Paths.get("src", "test",
                    "resources", "drivers", "linux", driverName).toAbsolutePath().toString();
        } else {
            throw new UnsupportedOperationException("Данная операционная система не поддерживается: " + os);
        }
    }

    public static void setupDriver() {
        String driverPath = getDriverPath();
        System.setProperty("webdriver.chrome.driver", driverPath);
        System.out.println("Используется доайвер: " + driverPath);
    }
}
