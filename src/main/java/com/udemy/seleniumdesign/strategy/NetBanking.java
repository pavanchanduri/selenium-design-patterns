package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import lombok.NonNull;

public class NetBanking implements IPaymentOption {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement account;

    @FindBy(id = "pin")
    private WebElement pin;

    /**
     * This method is used to enter the payment information for net banking.
     * It takes a map of payment details and fills in the respective fields.
     *
     * @param paymentDetails A map containing payment details such as bank, account, and pin.
     */
    @Override
    public void enterPaymentInformation(@NonNull Map<String, String> paymentDetails) {
        Select bankDropdown = new Select(bank);
        bankDropdown.selectByValue(paymentDetails.get("bank"));
        this.account.sendKeys(paymentDetails.get("account"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}
