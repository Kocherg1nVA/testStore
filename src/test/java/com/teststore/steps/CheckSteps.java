package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.teststore.model.BackgroundColors;
import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CheckSteps extends AbstractSteps {
    private AbstractPage currentPage;

    @И(value = "^(.+) > проверить по полному совпадению, что на странице присутствует текст \"(.+)\"$")
    public void checkTextExactMatchOnPage(String pageName, String expectedText) {
        LOGGER.info("Проверка точного совпадения текста '{}' на странице '{}'", expectedText, pageName);

        try {
            PageFactory.getPage(pageName);
            $(By.xpath(String.format("//*[text()='%s']", expectedText))).shouldBe(Condition.visible,
                    Duration.ofSeconds(15));
            LOGGER.info("Успешно: на странице '{}' присутствует полное совпадение текста '{}'",
                    pageName, expectedText);
        } catch (ElementNotFound e) {
            LOGGER.error("Ошибка: на странице '{}' отсутствует полное совпадение текста '{}'",
                    pageName, expectedText);
            throw e;
        }
    }

    @И(value = "^(.+) > проверить, что на странице присутствует текст \"(.+)\"$")
    public void checkTextPartialMatchOnPage(String pageName, String expectedText) {
        LOGGER.info("Проверка наличия текста '{}' на странице '{}'", expectedText, pageName);

        try {
            PageFactory.getPage(pageName);
            $(By.xpath(String.format("//*[contains(., '%s')]", expectedText))).shouldBe(Condition.visible,
                    Duration.ofSeconds(15));
            LOGGER.info("Успешно: на странице '{}' текст присутствует '{}'", pageName, expectedText);
        } catch (ElementNotFound e) {
            LOGGER.error("Ошибка: на странице '{}' текст отсутствует '{}'", pageName, expectedText);
            throw e;
        }
    }

    @И(value = "^(.+) > проверить, что элемент \"(.+)\" содержит текст \"(.+)\"$")
    public void checkElementContainText(String pageName, String elementName, String expectedText) {
        LOGGER.info("Проверка элемента '{}' на содержание текста '{}'", elementName, expectedText);

        try {
            currentPage = PageFactory.getPage(pageName);
            currentPage.getElement(elementName).shouldBe(Condition.visible).shouldHave(Condition.text(expectedText));
            LOGGER.info("Успешно: элемент '{}' содержит текст '{}'", elementName, expectedText);
        } catch (Exception e) {
            LOGGER.error("Ошибка: элемент '{}' не содержит текст '{}'", elementName, expectedText);
            throw e;
        }
    }

    @И(value = "^(.+) > проверить, что элемент \"(.+)\" окрасился в \"(.+)\" цвет$")
    public void checkColorChange(String pageName, String elementName, String colorName) {
        LOGGER.info("Проверка, что элемент '{}' окрасился в '{}' цвет", elementName, colorName);
        try {
            currentPage = PageFactory.getPage(pageName);
            BackgroundColors expectedColor = BackgroundColors.valueOf(colorName.toUpperCase());
            String expectedColorCode = expectedColor.getColorCode();
            currentPage.getElement(elementName).shouldHave(Condition.cssValue("background-color",
                    expectedColorCode));
            LOGGER.info("Успешно: на странице '{}' элемент '{}' окрасился в '{}' цвет", pageName, elementName, colorName);
        } catch (IllegalArgumentException e) {
            String errorMsg = String.format("Цвет '%s' не поддерживается. Доступные цвета: %s",
                    colorName, Arrays.toString(BackgroundColors.values()));
            LOGGER.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        } catch (AssertionError e) {
            String actualColor = currentPage.getElement(elementName).getCssValue("background-color");
            LOGGER.error("Ошибка: на странице '{}' цвет элемента '{}' не соответствует ожидаемому, фактический цвет '{}'",
                    pageName, elementName, actualColor);
            throw e;
        }
    }

    @И(value = "^(.+) > проверить, что чек-бокс \"(.+)\" (установлен|снят)$")
    public void checkCheckboxState(String pageName, String checkboxName, String expectedState) {
        currentPage = PageFactory.getPage(pageName);
        SelenideElement checkbox = currentPage.getElement(checkboxName);
        boolean shouldBeChecked = expectedState.equals("установлен");
        checkbox.shouldBe(shouldBeChecked ? Condition.selected : Condition.not(Condition.selected));
        LOGGER.info("Успешно: чек-бокс '{}' {}", checkboxName, shouldBeChecked ? "установлен" : "снят");
    }
    //TODO реализовать метод проверки отмечен/не отмечен чек-бокс
}
