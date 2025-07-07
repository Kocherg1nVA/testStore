package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SpecialsPage extends AbstractPage {

    @NameOfElement("Special offers accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Special Offers')]")
    public SelenideElement specialOffersTitle;

    @Override
    public void switchToPage() {
        specialOffersTitle.shouldBe(Condition.visible);
    }
}
