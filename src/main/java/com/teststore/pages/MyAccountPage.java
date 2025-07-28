package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends CommonPage {

    @NameOfElement("My Account title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'My Account')]")
    public SelenideElement titleMyAccount;

    @NameOfElement("User name")
    @FindBy(xpath = "//span[@class='subtext']")
    public SelenideElement titleUserName;


    @Override
    public void switchToPage() {
        titleMyAccount.shouldBe(Condition.visible);
        titleUserName.shouldBe(Condition.visible);
    }
}
