package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @NameOfElement("Slider")
    @FindBy(xpath = "//div[@class='oneByOneSlide']")
    public SelenideElement slider;

    @NameOfElement("Promo Section")
    @FindBy(xpath = "//section[@class='row promo_section']")
    public SelenideElement promoSection;

    @NameOfElement("Login or register button (header)")
    @FindBy(xpath = "//a[text()='Login or register']")
    public SelenideElement buttonLoginOrRegister;

    @NameOfElement("Specials button (header)")
    @FindBy(xpath = "//li[@class='dropdown']//span[@class='menu_text' and contains(text(),'Specials')]")
    public SelenideElement buttonSpecials;

    @NameOfElement("Account button (header)")
    @FindBy(xpath = "//li[@class='dropdown']//span[@class='menu_text' and contains(text(),'Account')]")
    public SelenideElement buttonAccount;

    @NameOfElement("Cart button (header)")
    @FindBy(xpath = "//li[@class='dropdown']//span[@class='menu_text' and contains(text(),'Cart')]")
    public SelenideElement buttonCart;

    @NameOfElement("Checkout button (header)")
    @FindBy(xpath = "//li[@class='dropdown']//span[@class='menu_text' and contains(text(),'Checkout')]")
    public SelenideElement buttonCheckout;

    @NameOfElement("Home button")
    @FindBy(xpath = "//a[@class='active menu_home']")
    public SelenideElement buttonHome;

    @NameOfElement("Apparel and Accessories button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Apparel & accessories')]")
    public SelenideElement apparelAndAccessoriesButton;

    @NameOfElement("Makeup button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Makeup')]")
    public SelenideElement makeupButton;

    @NameOfElement("Skincare button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Skincare')]")
    public SelenideElement skincareButton;

    @NameOfElement("Fragrance button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Fragrance')]")
    public SelenideElement fragranceButton;

    @NameOfElement("Men button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Men')]")
    public SelenideElement menButton;

    @NameOfElement("Hair care button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Hair Care')]")
    public SelenideElement hairCareButton;

    @NameOfElement("Books button")
    @FindBy(xpath = "//a[@href and contains (text(), 'Books')]")
    public SelenideElement booksButton;

    @Override
    public void switchToPage() {
        slider.shouldBe(Condition.visible);
        promoSection.shouldBe(Condition.visible);
    }
}
