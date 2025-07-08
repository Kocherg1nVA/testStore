package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ApparelAndAccessoriesPage extends CommonPage {

    @NameOfElement("Apparel and accessories accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Apparel & accessories')]")
    public SelenideElement apparelAndAccessoriesTitle;

    @Override
    public void switchToPage() {
        apparelAndAccessoriesTitle.shouldBe(Condition.visible);
    }
}
