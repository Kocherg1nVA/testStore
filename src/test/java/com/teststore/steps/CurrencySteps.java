package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.teststore.model.Currency;
import io.cucumber.java.ru.И;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CurrencySteps extends AbstractSteps {

    @И("^Выбрать валюту \"(.+)\"$")
    public void selectCurrency(String currencyName) {
        LOGGER.info("Начало выбора валюты: {}", currencyName);

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

    @И("^Проверить, что выбрана валюта \"(.+)\"$")
    public void checkCurrency(String currencyName) {
        LOGGER.info("Начало проверки валюты. Ожидаемая валюта: {}", currencyName);

        try {
            String fullText = $(byXpath("//span[@class='label label-orange font14']/parent::span"))
                    .shouldBe(Condition.visible)
                    .getText();
            LOGGER.debug("Полный текст элемента: {}", fullText);

            String actualCurrency = fullText
                    .split(" ", 2)[1]
                    .replaceAll("\"|==.*$", "")
                    .trim()
                    .toLowerCase();
            LOGGER.debug("Извлеченное название валюты после обработки: {}", actualCurrency);

            String expectedCurrency = currencyName.toLowerCase();
            LOGGER.debug("Ожидаемое название валюты после обработки: {}", expectedCurrency);

            if (expectedCurrency.equals(actualCurrency)) {
                LOGGER.info("Валюта соответствует: ожидалось '{}', фактически '{}'",
                        expectedCurrency, actualCurrency);
            } else {
                throw new AssertionError(String.format("Ожидалась валюта '%s', но найдена '%s'",
                        expectedCurrency, actualCurrency));
            }
        } catch (Exception e) {
            LOGGER.error("Ошибка при проверке валюты '{}' : {}", currencyName, e.getMessage(), e);
            throw e;
        }
    }
}