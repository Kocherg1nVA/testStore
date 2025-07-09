package com.teststore.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;

public class ActionSteps extends AbstractSteps {
    AbstractPage currentPage;

    @И(value = "^(.+) > нажать на элемент \"(.+)\"$")
    public void clickOnElement(String pageName, String elementName) {
        LOGGER.info("На странице '{}' произвести нажатие на элемент '{}'", pageName, elementName);
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
        LOGGER.info("На странице '{}' ввести текст '{}' в поле '{}'", pageName, text, elementName);
        try {
            currentPage = PageFactory.getPage(pageName);
            currentPage.getElement(elementName).shouldBe(Condition.visible).setValue(text);
            LOGGER.info("Успешно: на странице '{}' введен текст '{}' в поле '{}' ",
                    pageName, text, elementName);
        } catch (Exception e) {
            LOGGER.error("Ошибка: на странице '{}' не удалось ввести текст '{}' в поле '{}'",
                    pageName, text, elementName);
            throw e;
        }
    }

    @И(value = "^(.+) > выбрать элемент из выпадающего меню \"(.+)\" по тексту \"(.+)\"$")
    public void selectElementOnDropdownMenuByText(String pageName, String elementName, String text) {
        LOGGER.info("На странице '{}' выбрать опцию выпадающего меню '{}' по тексту '{}'",
                pageName, elementName, text);
        try {
            currentPage = PageFactory.getPage(pageName);
            currentPage.getElement(elementName).selectOptionContainingText(text);
            LOGGER.info("Успешно: на странице '{}' выбрана опция выпадающего меню '{}' по тексту '{}'",
                    pageName, elementName, text);
        } catch (Exception e) {
            LOGGER.error("Ошибка: на странице '{}' не удалось выбрать опцию выпадающего меню '{}' по тексту '{}'",
                    pageName, elementName, text);
            throw e;
        }
    }

    @И(value = "^(.+) > выбрать элемент из выпадающего меню \"(.+)\" по индексу (\\d+)$")
    public void selectElementOnDropdownMenuByIndex(String pageName, String elementName, int index) {
        LOGGER.info("На странице '{}' выбрать опцию выпадающего меню '{}' по индексу '{}'",
                pageName, elementName, index);
        try {
            currentPage = PageFactory.getPage(pageName);
            SelenideElement dropdown = currentPage.getElement(elementName);
            String optionText = dropdown.$$("option").get(index).getText().replaceAll("^\\s+", "");
            dropdown.selectOption(index);
            LOGGER.info("Успешно: на странице '{}' выбрана опция '{}' выпадающего меню '{}' по индексу '{}'",
                    pageName, optionText, elementName, index);
        } catch (Exception e) {
            LOGGER.error("Ошибка: на странице '{}' не удалось выбрать опцию выпадающего меню '{}' по индексу '{}'",
                    pageName, elementName, index);
            throw e;
        }
    }
    //TODO реализовать методы для взаимодействия с чек-боксами
}
