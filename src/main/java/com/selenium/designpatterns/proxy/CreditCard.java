package com.selenium.designpatterns.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import lombok.NonNull;

public class CreditCard implements IPaymentOption {

    @FindBy(id = "cc")
    private WebElement cc;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    /**
     * Enter payment information for credit card.
     * @param paymentDetails Map containing payment details with keys "cc", "year", and "cvv".
     * @throws NullPointerException if paymentDetails is null or does not contain required keys.
     * @throws IllegalArgumentException if paymentDetails does not contain all required keys.
     */
    @Override
    public void enterPaymentInformation(@NonNull final Map<String, String> paymentDetails) {
        this.cc.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
