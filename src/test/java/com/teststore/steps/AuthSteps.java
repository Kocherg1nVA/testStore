package com.teststore.steps;

import com.codeborne.selenide.Selenide;
import com.teststore.config.Config;
import com.teststore.pages.LoginPage;
import com.teststore.pages.MyAccountPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;

public class AuthSteps extends AbstractSteps{

    @И("Авторизоваться на сайте под логином {string}")
    public void Auth(String login) {
        checkLogin(login);
        LOGGER.debug("Начало процесса авторизации для пользователя: {}", login);

        Selenide.open(Config.getLoginUrl());
        LOGGER.trace("Открыта страница авторизации: {}", Config.getLoginUrl());

        LoginPage loginPage = PageFactory.getPage(LoginPage.class);
        loginPage.fieldLoginName.setValue(login);
        LOGGER.trace("Введен логин: {}", login);

        loginPage.fieldPassword.setValue(Config.getPassword());
        LOGGER.trace("Введен пароль");

        loginPage.buttonLogin.click();
        LOGGER.debug("Нажата кнопка входа");

        PageFactory.getPage(MyAccountPage.class);
        LOGGER.info("Успешная авторизация пользователя: {}", login);
    }

    //вспомогательные методы

    public void checkLogin(String login) {
        if (login.equals(Config.getLogin())) {
            LOGGER.info("Пользователь с логином '{}' верифицирован успешно", login);
        } else {
            String errMessage = String.format("Пользователь с логином - '%s' не верифицирован", login);
            LOGGER.error(errMessage);
            throw new SecurityException(errMessage);
        }
    }
}
