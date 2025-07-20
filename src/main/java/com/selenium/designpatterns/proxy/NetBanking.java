package com.selenium.designpatterns.proxy;

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
     * Enter payment information for net banking.
     * @param paymentDetails Map containing payment details with keys "bank", "account", and "pin".
     * @throws NullPointerException if paymentDetails is null or does not contain required keys.
     * @throws IllegalArgumentException if paymentDetails does not contain all required keys.
     */
    @Override
    public void enterPaymentInformation(@NonNull final Map<String, String> paymentDetails) {
        Select bankDropdown = new Select(bank);
        bankDropdown.selectByValue(paymentDetails.get("bank"));
        this.account.sendKeys(paymentDetails.get("account"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}
