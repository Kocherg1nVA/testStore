package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Skincare extends AbstractPage {

    @NameOfElement("Skincare title")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Skincare')]")
    public SelenideElement skincareTitle;

    @Override
    public void switchToPage() {
        skincareTitle.shouldBe(Condition.visible);
    }
}
