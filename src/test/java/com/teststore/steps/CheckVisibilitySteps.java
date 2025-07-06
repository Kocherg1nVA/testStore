package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CheckVisibilitySteps extends AbstractSteps {

    @И(value = "^(.+) > проверить по полному совпадению, что на странице присутствует текст \"(.+)\"$")
    public void checkTextExactMatchOnPage(String pageName, String expectedText) {
        LOGGER.info("Проверка точного совпадения текста '{}' на странице '{}'", expectedText, pageName);

        try {
            PageFactory.getPage(pageName);
            $(By.xpath(String.format("//*[text()='%s']", expectedText))).shouldBe(Condition.visible,
                    Duration.ofSeconds(15));
            LOGGER.info("Успешно: присутствует полное совпадение текста '{}' на странице '{}'", expectedText, pageName);
        } catch (ElementNotFound e) {
            LOGGER.error("Ошибка: отсутствует полное совпадение текста '{}' на странице '{}'",
                    expectedText, pageName);
            throw e;
        }
    }

    @И(value = "^(.+) > проверить по частичному совпадению, что на странице присутствует текст \"(.+)\"$")
    public void checkTextPartialMatchOnPage(String pageName, String expectedText) {
        LOGGER.info("Проверка частичного совпадения текста '{}' на странице '{}'", expectedText, pageName);

        try {
            PageFactory.getPage(pageName);
            $(By.xpath(String.format("//*[contains(text(),'%s')]", expectedText))).shouldBe(Condition.visible,
                    Duration.ofSeconds(15));
            LOGGER.info("Успешно: присутствует частичное совпадение текст '{}' на странице '{}'", expectedText, pageName);
        } catch (ElementNotFound e) {
            LOGGER.error("Ошибка: отсутствует частичное совпадение текста '{}' на странице '{}'",
                    expectedText, pageName);
            throw e;
        }
    }
}
