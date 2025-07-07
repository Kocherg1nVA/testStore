package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends AbstractPage {

    @NameOfElement("Books accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Books')]")
    public SelenideElement booksTitle;

    @Override
    public void switchToPage() {
        booksTitle.shouldBe(Condition.visible);
    }
}
