package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogoutPage extends AbstractPage {

    @NameOfElement("Account Logout title")
    @FindBy(xpath = "//span[@class='maintext']")
    public SelenideElement titleAccountLogout;

    @NameOfElement("Continue button")
    @FindBy(xpath = "//a[@title='Continue']")
    public SelenideElement buttonContinue;

    @Override
    public void switchToPage() {
        titleAccountLogout.shouldBe(Condition.visible);
    }
}
