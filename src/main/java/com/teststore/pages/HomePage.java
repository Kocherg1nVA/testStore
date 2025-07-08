package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {

    @NameOfElement("Slider")
    @FindBy(xpath = "//div[@class='oneByOneSlide']")
    public SelenideElement slider;

    @NameOfElement("Promo Section")
    @FindBy(xpath = "//section[@class='row promo_section']")
    public SelenideElement promoSection;

    @NameOfElement("Featured title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Featured')]")
    public SelenideElement titleFeatured;

    @NameOfElement("Latest products title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Latest Products')]")
    public SelenideElement titleLatestProducts;

    @NameOfElement("Bestsellers title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Bestsellers')]")
    public SelenideElement titleBestsellers;

    @NameOfElement("Specials title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Specials')]")
    public SelenideElement titleSpecials;

    @NameOfElement("Brands scrolling list title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Brands Scrolling List')]")
    public SelenideElement titleBrandsList;

    @Override
    public void switchToPage() {
        slider.shouldBe(Condition.visible);
        promoSection.shouldBe(Condition.visible);
    }
}
