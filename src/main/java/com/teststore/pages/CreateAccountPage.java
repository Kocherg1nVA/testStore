package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends CommonPage {

    @NameOfElement("Create Account title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Create Account')]")
    public SelenideElement createAccountTitle;

    @NameOfElement("First Name field")
    @FindBy(xpath = "//input[@id='AccountFrm_firstname']")
    public SelenideElement fieldFirstName;

    @NameOfElement("Last Name field")
    @FindBy(xpath = "//input[@id='AccountFrm_lastname']")
    public SelenideElement fieldLastName;

    @NameOfElement("Email field")
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    public SelenideElement fieldEmail;

    @NameOfElement("Telephone field")
    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    public SelenideElement fieldTelephone;

    @NameOfElement("Fax field")
    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    public SelenideElement fieldFax;

    @NameOfElement("Company field")
    @FindBy(xpath = "//input[@id='AccountFrm_company']")
    public SelenideElement fieldCompany;

    @NameOfElement("Address1 field")
    @FindBy(xpath = "//input[@id='AccountFrm_address_1']")
    public SelenideElement fieldAddress1;

    @NameOfElement("Address2 field")
    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    public SelenideElement fieldAddress2;

    @NameOfElement("City field")
    @FindBy(xpath = "//input[@id='AccountFrm_city']")
    public SelenideElement fieldCity;

    @NameOfElement("Region / State dropdown")
    @FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
    public SelenideElement dropdownReginState;

    @NameOfElement("ZIP Code field")
    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    public SelenideElement fieldZIPCode;

    @NameOfElement("Country dropdown")
    @FindBy(xpath = "//select[@id='AccountFrm_country_id']")
    public SelenideElement dropdownCountry;

    @NameOfElement("Login name field")
    @FindBy(xpath = "//input[@id='AccountFrm_loginname']")
    public SelenideElement fieldLoginName;

    @NameOfElement("Password field")
    @FindBy(xpath = "//input[@id='AccountFrm_password']")
    public SelenideElement fieldPassword;

    @NameOfElement("Password Confirm field")
    @FindBy(xpath = "//input[@id='AccountFrm_confirm']")
    public SelenideElement fieldPasswordConfirm;

    @NameOfElement("Subscribe Yes radio button")
    @FindBy(xpath = "//input[@id='AccountFrm_newsletter1']")
    public SelenideElement radioButtonSubscribeYes;

    @NameOfElement("Subscribe No radio button")
    @FindBy(xpath = "//input[@id='AccountFrm_newsletter0']")
    public SelenideElement radioButtonSubscribeNo;

    @NameOfElement("Privacy Policy checkbox")
    @FindBy(xpath = "//input[@id='AccountFrm_agree']")
    public SelenideElement checkBoxPrivacyPolicy;

    @NameOfElement("Continue button")
    @FindBy(xpath = "//button[@title='Continue']")
    public SelenideElement buttonContinue;


    @Override
    public void switchToPage() {
        createAccountTitle.shouldBe(Condition.visible);
    }
}
