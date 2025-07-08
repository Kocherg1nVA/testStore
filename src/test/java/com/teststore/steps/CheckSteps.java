package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

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

    @И(value = "^(.+) > проверить, что элемент \"(.+)\" окрасился в синий цвет")
    public void checkColorChange(String pageName, String elementName) {
        LOGGER.info("Проверка, что элемент '{}' окрасился в синий цвет", elementName);
        try {
            currentPage = PageFactory.getPage(pageName);
            currentPage.getElement(elementName).shouldHave(Condition.cssValue("background-color",
                    "rgba(0, 161, 203, 1)"));
            LOGGER.info("Успешно: на странице '{}' элемент '{}' окрасился в синий цвет", pageName, elementName);
        } catch (AssertionError e) {
            String actualColor = currentPage.getElement(elementName).getCssValue("background-color");
            LOGGER.error("Ошибка: на странице '{}' цвет элемента '{}' не соответствует ожидаемому, фактический цвет '{}'",
                    pageName, elementName, actualColor);
            throw e;
        }
    }
}
