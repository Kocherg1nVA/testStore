package com.teststore.steps;

import com.codeborne.selenide.Selenide;
import com.teststore.config.Config;
import io.cucumber.java.ru.Дано;

public class BrowserSteps {

    @Дано("Открыть главную страницу")
    public void openHomePage() {
        Selenide.open(Config.getBaseUrl());
    }
}
