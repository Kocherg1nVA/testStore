package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HairCare extends AbstractPage {

    @NameOfElement("Hair Care accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Hair Care')]")
    public SelenideElement hairCareTitle;

    @Override
    public void switchToPage() {
        hairCareTitle.shouldBe(Condition.visible);
    }
}
