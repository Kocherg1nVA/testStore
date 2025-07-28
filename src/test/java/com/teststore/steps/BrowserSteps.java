package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import com.teststore.config.Config;
import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;

import java.time.Duration;

public class BrowserSteps extends AbstractSteps{
    AbstractPage currentPage;

    @Дано("Открыть домашнюю страницу")
    public void openHomePage() {
        Selenide.open(Config.getBaseUrl());
        LOGGER.info("Успешно: домашняя страница: {} открыта", Config.getBaseUrl());
    }

    @И("^Перейти по URL \"(/+)\"$")
    public void navigateToUrl(String url) {
        Selenide.open(url);
        LOGGER.info("Успешно: завершен переход на страницу '{}'", url);
    }

    @И("Обновить страницу браузера")
    public void refreshPage() {
        Selenide.refresh();
        LOGGER.info("Успешно: страница браузера обновлена");
    }

    @И("Вернуться на предыдущую страницу браузера")
    public void goBack() {
        Selenide.back();
        LOGGER.info("Успешно: осуществлен возврат на предыдущую страницу");
    }

    @И("Перейти на следующую страницу (вперед) браузера")
    public void goForward() {
        Selenide.forward();
        LOGGER.info("Успешно: осуществлен переход на следующую страницу");
    }

    @И(value = "^Переключиться на вкладку браузера с индексом \"(/+)\"$")
    public void switchToTab(int index) {
        Selenide.switchTo().window(index);
        LOGGER.info("Успешно: осуществлен переход на вкладку с индексом '{}'", index);
    }

    @И(value = "^(.+) > проскроллить страницу до текста \"(.+)\"$")
    public void scrollToText(String pageName, String text) {
        LOGGER.info("Проскроллить страницу '{}' до текста '{}'", pageName, text);
        try {
            $(byText(text)).scrollIntoView("{behavior: 'smooth', block: 'center'}");
            $(byText(text)).shouldBe(Condition.visible, Duration.ofSeconds(15));
            LOGGER.info("Успешно: осуществлен скролл страницы '{}' до текста '{}'", pageName, text);
        } catch (AssertionError e) {
            String errMessage = String.format("Ошибка: не удалось проскроллить страницу '%s' до текста '%s'", pageName, text);
            LOGGER.info(errMessage);
            throw new AssertionError(errMessage);
        }
    }

    @И(value = "^(.+) > проскроллить страницу до элемента \"(.+)\"$")
    public void scrollToElement(String pageName, String elementName) {
        LOGGER.info("Проскроллить страницу '{}' до элемента '{}'", pageName, elementName);
        try {
            currentPage = PageFactory.getPage(pageName);
            SelenideElement dropdown = currentPage.getElement(elementName);
            dropdown.scrollIntoView(true).shouldBe(Condition.visible, Duration.ofSeconds(15));
            LOGGER.info("Успешно: осуществлен скролл страницы '{}' до элемента '{}'", pageName, elementName);
        } catch (IllegalArgumentException e) {
            String errMessage = String.format("Ошибка: на странице '%s' не найден элемент с именем '%s'", pageName, elementName);
            LOGGER.info(errMessage);
            throw new IllegalArgumentException(errMessage);
        }
    }

    @И(value = "^ожидать (\\d+) секунд$")
    public void waitSeconds(int seconds) {
        sleep(seconds * 1000L);
        LOGGER.info("Успешно: завершено ожидание в течении '{}' секунд", seconds);
    }

    @И("ожидать загрузки страницы")
    public void waitForPageLoad() {
        Selenide.Wait()
                .withTimeout(Duration.ofSeconds(15))
                .until(d -> executeJavaScript("return document.readyState"))
                .equals("complete");
        LOGGER.info("Успешно: завершено ожидание загрузки страницы");
    }

    //TODO реализовать метод ожидания появления элемента в течении n секунд

}
