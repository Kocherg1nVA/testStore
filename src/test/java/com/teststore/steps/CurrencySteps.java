package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.teststore.model.Currency;
import io.cucumber.java.ru.И;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CurrencySteps {

    @И("Выбрать валюту {string}")
    public void selectCurrency(String currencyName) {
        Currency currency = Currency.fromString(currencyName);
        $(byXpath("//ul[@class='nav language pull-left']")).hover();
        $(byXpath("//ul[@class='dropdown-menu currency']")).shouldBe(Condition.visible);
        $(byXpath("//ul[@class='dropdown-menu currency']//a[contains(., '" + currency.getDisplayName() + "')]")).click();
    }
}