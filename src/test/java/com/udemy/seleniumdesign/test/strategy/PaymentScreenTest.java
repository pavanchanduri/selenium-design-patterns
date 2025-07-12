package com.udemy.seleniumdesign.test.strategy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.strategy.PaymentOptionFactory;
import com.udemy.seleniumdesign.strategy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    /**
     * Sets up the PaymentScreen instance before running the tests.
     * This method initializes the PaymentScreen with the WebDriver instance.
     */
    @BeforeTest
    public void setPaymentScreen(){
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    /**
     * Tests the payment functionality with different payment options.
     * It navigates to the payment screen, enters user details, selects a payment option,
     * and places an order, printing the order number to the console.
     *
     * @param option         the payment option to test (e.g., "CC" for credit card, "NB" for net banking)
     * @param paymentDetails a map containing payment details specific to the selected option
     */
    @Test(dataProvider = "getData")
    public void paymentTest(@NonNull final String option, @NonNull final Map<String, String> paymentDetails){
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("vinoth", "selvaraj", "udemy@gmail.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println(
                "Order Number : " + orderNumber
        );

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    /**
     * Provides test data for the paymentTest method.
     * It returns a 2D array of objects, where each object contains a payment option
     * and the corresponding payment details.
     *
     * @return a 2D array of objects containing payment options and their details
     */
    @DataProvider
    public Object[][] getData(){

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "1231231231");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "myaccount123");
        nb.put("pin", "999");

        return new Object[][]{
                {"CC", cc} ,
                {"NB", nb}
        };
    }

}
