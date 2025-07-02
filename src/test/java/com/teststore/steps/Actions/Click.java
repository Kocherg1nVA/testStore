package com.teststore.steps.Actions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;

public class Click {
    @Когда(value = "^{страница} > нажать на элемент \"([^\"]*)\"$")
    public void clickOnElement(String pageName, String elementName) {
        AbstractPage page = PageFactory.getPage(pageName);
//        SelenideElement element =
    }
}
