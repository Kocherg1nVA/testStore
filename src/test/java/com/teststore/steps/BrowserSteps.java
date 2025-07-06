package com.teststore.steps;

import com.codeborne.selenide.Selenide;
import com.teststore.config.Config;
import io.cucumber.java.ru.Дано;

public class BrowserSteps extends AbstractSteps{

    @Дано("Открыть домашнюю страницу")
    public void openHomePage() {
        Selenide.open(Config.getBaseUrl());
        LOGGER.info("Домашняя страница: {} успешно открыта", Config.getBaseUrl());
    }
}
