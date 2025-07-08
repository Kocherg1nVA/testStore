package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @NameOfElement("Account login accountLoginTitle")
    @FindBy(xpath = "//span[@class='maintext' and contains (text(), 'Account Login')]")
    public SelenideElement accountLoginTitle;

    @NameOfElement("I am a new customer title")
    @FindBy(xpath = "//h2[@class='heading2' and contains (text(), 'I am a new customer')]")
    public SelenideElement newCustomerTitle;

    @NameOfElement("Returning customer title")
    @FindBy(xpath = "//h2[@class='heading2' and contains (text(), 'Returning Customer')]")
    public SelenideElement returningCustomerTitle;

    @NameOfElement("Register account radio button")
    @FindBy(xpath = "//input[@type='radio']")
    public SelenideElement radioButtonRegisterAccount;

    @NameOfElement("Continue registration button")
    @FindBy(xpath = "//button[@title='Continue']")
    public SelenideElement buttonContinueReg;

    @NameOfElement("Login name field")
    @FindBy(xpath = "//input[@id='loginFrm_loginname']")
    public SelenideElement fieldLoginName;

    @NameOfElement("Password field")
    @FindBy(xpath = "//input[@id='loginFrm_password']")
    public SelenideElement fieldPassword;

    @NameOfElement("Forgot your password button")
    @FindBy(xpath = "//a[@href and contains(text(), 'Forgot your password?')]")
    public SelenideElement buttonForgotYourPassword;

    @NameOfElement("Forgot your login")
    @FindBy(xpath = "//a[@href and contains(text(), 'Forgot your login?')]")
    public SelenideElement buttonForgotYourLogin;

    @NameOfElement("Login button")
    @FindBy(xpath = "//button[@title='Login']")
    public SelenideElement buttonLogin;

    @Override
    public void switchToPage() {
        accountLoginTitle.shouldBe(Condition.visible);
    }
}
