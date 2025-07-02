package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @NameOfElement("Title")
    @FindBy(xpath = "//span[@class='maintext']")
    public SelenideElement title;


    @Override
    public void switchToPage() {
        title.shouldBe(Condition.visible);
    }
}
