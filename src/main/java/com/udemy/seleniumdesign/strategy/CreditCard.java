package com.udemy.seleniumdesign.strategy;

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
     * This method is used to enter the payment information for credit card.
     * It takes a map of payment details and fills in the respective fields.
     *
     * @param paymentDetails A map containing payment details such as cc, year, and cvv.
     */
    @Override
    public void enterPaymentInformation(@NonNull final Map<String, String> paymentDetails) {
        this.cc.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
