package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ApparelAndAccessories extends AbstractPage {

    @NameOfElement("Apparel and accessories title")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Apparel & accessories')]")
    public SelenideElement apparelAndAccessoriesTitle;

    @Override
    public void switchToPage() {
        apparelAndAccessoriesTitle.shouldBe(Condition.visible);
    }
}
