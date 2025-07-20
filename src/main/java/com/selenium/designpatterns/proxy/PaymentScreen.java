package com.selenium.designpatterns.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import lombok.NonNull;
import lombok.Getter;

public class PaymentScreen {

    private WebDriver driver;
    private @Getter UserInformation userInformation;
    private @Getter IOrderComponent orderComponent;
    private IPaymentOption paymentOption;

    /**
     * Constructor for PaymentScreen.
     *
     * @param driver the WebDriver instance to use for this screen
     */
    public PaymentScreen(@NonNull final WebDriver driver){
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.orderComponent = new OrderComponentProxy(driver);
    }

    /**
     * Navigates to the payment screen URL.
     */
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    /**
     * Sets the payment option for this screen.
     *
     * @param paymentOption the payment option to set
     */
    public void setPaymentOption(@NonNull final IPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    /**
     * Processes the payment with the provided payment details.
     *
     * @param paymentDetails a map containing payment details
     */
    public void pay(@NonNull final Map<String, String> paymentDetails){
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }
}
