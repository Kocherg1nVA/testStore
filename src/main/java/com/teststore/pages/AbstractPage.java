package com.teststore.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AbstractPage {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    protected SelenideElement $(By locator) {
        return $(locator);
    }

    protected void click(SelenideElement element) {
        logger.info("Клик по элементу: " + element.getSearchCriteria());
        element.click();
    }

    protected void type(SelenideElement element, String text) {
        logger.info("Ввод текста: " + text + "в элемент: " + element.getSearchCriteria());
        element.setValue(text);
    }

    protected String getText(SelenideElement element) {
        logger.info("Получение текста из элемента: " + element.getSearchCriteria());
        return element.getText();
    }
}
