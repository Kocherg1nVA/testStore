package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;

public class ActionSteps extends AbstractSteps {
    AbstractPage currentPage;

    @И(value = "^(.+) > нажать на элемент \"(.+)\"$")
    public void clickOnElement(String pageName, String elementName) {
        try {
            currentPage = PageFactory.getPage(pageName);
            currentPage.getElement(elementName).shouldBe(Condition.visible).click();
            LOGGER.info("Успешно: на странице '{}' произведено нажатие элемента '{}' ", pageName, elementName);
        } catch (Exception e) {
            LOGGER.error("Ошибка: на странице '{}' не найден элемент '{}'", pageName, elementName);
            throw e;
        }
    }

    @И(value = "^(.+) > ввести текст \"(.+)\" в поле \"(.+)\"$")
    public void enterTextToField(String pageName, String text, String elementName) {
        try {
            currentPage = PageFactory.getPage(pageName);
            currentPage.getElement(elementName).shouldBe(Condition.visible).setValue(text);
            LOGGER.info("Успешно: на странице '{}' введен текст '{}' в поле '{}' ", pageName, text, elementName);
        } catch (Exception e) {
            LOGGER.error("Ошибка: на странице '{}' не удалось ввести текст '{}' в поле '{}'", pageName, text, elementName);
        }
    }
}
