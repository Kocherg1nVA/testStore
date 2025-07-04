package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.teststore.model.Currency;
import io.cucumber.java.ru.И;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CurrencySteps {
    private static final Logger LOGGER = LogManager.getLogger(CurrencySteps.class);

    @И("Выбрать валюту {string}")
    public void selectCurrency(String currencyName) {
        LOGGER.info("Начало выбора валюты: ()", currencyName);

        try {
            Currency currency = Currency.fromString(currencyName);
            LOGGER.debug("Конвертация валюты выполнена: {} -> {}", currencyName, currency);

            $(byXpath("//ul[@class='nav language pull-left']")).hover();
            LOGGER.debug("Наведение курсора на элемент выполнено");

            $(byXpath("//ul[@class='dropdown-menu currency']")).shouldBe(Condition.visible);
            LOGGER.debug("Меню выбора валют стало видимым");

            $(byXpath("//ul[@class='dropdown-menu currency']//a[contains(., '" + currency.getDisplayName() + "')]")).click();
            LOGGER.info("Валюта успешно выбрана: {}", currency.getDisplayName());
        } catch (Exception e) {
            LOGGER.error("Ошибка при выборе валюты '{}' : {}", currencyName, e.getMessage(), e);
            throw e;
        }
    }
}