package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import lombok.NonNull;
import lombok.Getter;

public class PaymentScreen {

    private WebDriver driver;
    private @Getter UserInformation userInformation;
    private @Getter Order order;
    private IPaymentOption paymentOption;

    /**
     * Constructor for PaymentScreen.
     * Initializes the WebDriver and the page elements using PageFactory.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public PaymentScreen(@NonNull final WebDriver driver){
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.order = PageFactory.initElements(driver, Order.class);
    }

    /**
     * Navigates to the payment screen URL.
     */
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    /**
     * Sets the payment option strategy.
     *
     * @param paymentOption the payment option strategy to be used
     */
    public void setPaymentOption(@NonNull final IPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    /**
     * Fills in user information.
     *
     * @param userDetails a map containing user details like name, email, and phone
     */
    public void pay(@NonNull final Map<String, String> paymentDetails) {
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }
}
