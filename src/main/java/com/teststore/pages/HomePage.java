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

    @Override
    public void switchToPage() {
        slider.shouldBe(Condition.visible);
        promoSection.shouldBe(Condition.visible);
    }
}
