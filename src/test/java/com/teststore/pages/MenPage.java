package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MenPage extends CommonPage {

    @NameOfElement("Men accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Men')]")
    public SelenideElement menTitle;

    @Override
    public void switchToPage() {
        menTitle.shouldBe(Condition.visible);
    }
}
