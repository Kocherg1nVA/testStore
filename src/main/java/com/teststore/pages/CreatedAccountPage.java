package com.teststore.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class CreatedAccountPage extends CommonPage {

    @NameOfElement("Created Account title")
    @FindBy(xpath = "//span[@class='maintext' and contains(text(), 'Your Account Has Been Created!')]")
    public SelenideElement titleCreatedAccount;

    @NameOfElement("Continue button")
    @FindBy(xpath = "//a[@title='Continue']")
    public SelenideElement buttonContinue;

    @NameOfElement("Account Dashboard")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Account Dashboard')]")
    public SelenideElement buttonAccountDashboard;

    @NameOfElement("My wish list")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'My wish list')]")
    public SelenideElement buttonMyWishList;

    @NameOfElement("Edit account details")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Edit account details')]")
    public SelenideElement buttonEditAccountDetails;

    @NameOfElement("Change password")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Change password')]")
    public SelenideElement buttonChangePassword;

    @NameOfElement("Manage Address Book")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Manage Address Book')]")
    public SelenideElement buttonManageAddressBook;

    @NameOfElement("Order history")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Order history')]")
    public SelenideElement buttonOrderHistory;

    @NameOfElement("Transaction history")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Transaction history')]")
    public SelenideElement buttonTransactionHistory;

    @NameOfElement("Downloads")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Downloads')]")
    public SelenideElement buttonDownloads;

    @NameOfElement("Notifications")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Notifications')]")
    public SelenideElement buttonNotifications;

    @NameOfElement("Logoff")
    @FindBy(xpath = "//ul[@class='side_account_list']//a[@href and contains(text(), 'Logoff')]")
    public SelenideElement buttonLogOff;

    @Override
    public void switchToPage() {
        titleCreatedAccount.shouldBe(Condition.visible);
    }
}

/*
Congratulations! Your new account has been successfully created!
You can now take advantage of member privileges to enhance your online shopping experience with us.
If you have ANY questions about the operation of this online shop, please email the store owner.
A confirmation has been sent to the provided email address. If you have not received it within the hour, please contact us.
 */

