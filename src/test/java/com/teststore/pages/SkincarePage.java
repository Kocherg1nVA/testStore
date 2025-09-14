package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SkincarePage extends CommonPage {

    @NameOfElement("Skincare accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Skincare')]")
    public SelenideElement skincareTitle;

    @Override
    public void switchToPage() {
        skincareTitle.shouldBe(Condition.visible);
    }
}
