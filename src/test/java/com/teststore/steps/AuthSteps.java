package com.teststore.steps;

import com.codeborne.selenide.Selenide;
import com.teststore.config.Config;
import io.cucumber.java.ru.И;

public class AuthSteps {

    @И("Авторизоваться на сайте под логином {string}")
    public void Auth(String login) {
        Selenide.open(Config.getBaseUrl());

    }
}
