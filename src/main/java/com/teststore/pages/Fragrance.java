package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Fragrance extends AbstractPage {

    @NameOfElement("Fragrance accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Fragrance')]")
    public SelenideElement fragranceTitle;

    @Override
    public void switchToPage() {
        fragranceTitle.shouldBe(Condition.visible);
    }
}
