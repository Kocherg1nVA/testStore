package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends AbstractPage {

    @NameOfElement("Cart accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), ' Shopping Cart')]")
    public SelenideElement cartTitle;

    @Override
    public void switchToPage() {
        cartTitle.shouldBe(Condition.visible);
    }
}
