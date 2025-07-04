package com.teststore.steps;

import com.codeborne.selenide.Selenide;
import com.teststore.config.Config;
import io.cucumber.java.ru.Дано;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BrowserSteps {
    private static final Logger LOGGER = LogManager.getLogger(BrowserSteps.class);

    @Дано("Открыть домашнюю страницу")
    public void openHomePage() {
        Selenide.open(Config.getBaseUrl());
        LOGGER.info("Домашняя страница: {} успешно открыта", Config.getBaseUrl());
    }
}
