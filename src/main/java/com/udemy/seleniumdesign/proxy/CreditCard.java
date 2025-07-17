package com.udemy.seleniumdesign.proxy;

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

    @Override
    public void enterPaymentInformation(@NonNull final Map<String, String> paymentDetails) {
        this.cc.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
