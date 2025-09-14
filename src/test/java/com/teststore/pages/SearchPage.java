package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends CommonPage {

    @NameOfElement("Search title")
    @FindBy(xpath = "//span[@class='maintext']")
    public SelenideElement titleSearch;

    @NameOfElement("Search criteria field")
    @FindBy(xpath = "//input[@id='keyword']")
    public SelenideElement fieldSearchCriteria;

    @NameOfElement("Category dropdown")
    @FindBy(xpath = "//select[@id='category_id']")
    public SelenideElement dropdownCategory;

    @NameOfElement("Search in product description checkbox")
    @FindBy(xpath = "//input[@id='description']")
    public SelenideElement checkboxSearchInProductDescription;

    @NameOfElement("Search in product model checkbox")
    @FindBy(xpath = "//input[@id='model']")
    public SelenideElement checkboxSearchInProductModel;

    @NameOfElement("Sort By dropdown")
    @FindBy(xpath = "//select[@id='sort']")
    public SelenideElement dropdownSortBy;

    @NameOfElement("Search button")
    @FindBy(xpath = "//button[@id='search_button']")
    public SelenideElement buttonSearch;

    @Override
    public void switchToPage() {
        titleSearch.shouldBe(Condition.visible);
    }
}
