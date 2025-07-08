package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MakeupPage extends CommonPage {

    @NameOfElement("Makeup accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Makeup')]")
    public SelenideElement makeupTitle;

    @Override
    public void switchToPage() {
        makeupTitle.shouldBe(Condition.visible);
    }
}
