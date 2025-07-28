package com.teststore.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;


public abstract class AbstractPage {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    public abstract void switchToPage();

    public SelenideElement getElement(String elementName) {
        return findElementByAnnotation(elementName)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Элемент с именем '%s' не найден на странице '%s'",
                        elementName, this.getClass().getSimpleName())));
    }

    private Optional<SelenideElement> findElementByAnnotation(String elementName) {
        return Arrays.stream(this.getClass().getFields())
                .filter(field -> field.isAnnotationPresent(NameOfElement.class))
                .filter(field -> field.getAnnotation(NameOfElement.class).value().equals(elementName))
                .findFirst()
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return (SelenideElement) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Не удалось получить доступ к полю: " + field.getName(),e);
                    }
                });
    }
}
