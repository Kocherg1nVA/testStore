package com.teststore.config;

import java.nio.file.Paths;

public class DriverConfiguration {

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

}
