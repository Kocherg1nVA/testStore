package com.teststore.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @NameOfElement("Login or register button (header)")
    @FindBy(xpath = "//a[text()='Login or register']")
    public SelenideElement buttonLoginOrRegister;

    @NameOfElement("Specials button (header)")
    @FindBy(xpath = "//li[@data-id='menu_specials' and @class='dropdown']//span[@class='menu_text' and contains(text(),'Specials')]")
    public SelenideElement buttonSpecials;
}
