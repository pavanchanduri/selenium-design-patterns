package com.selenium.designpatterns.test.proxy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.selenium.designpatterns.proxy.PaymentOptionFactory;
import com.selenium.designpatterns.proxy.PaymentScreen;
import com.selenium.designpatterns.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    /**
     * This method initializes the PaymentScreen object before running the tests.
     * It is annotated with @BeforeTest to ensure it runs before any test methods.
     */
    @BeforeTest
    public void setPaymentScreen(){
        System.setProperty("env", "PROD");
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    /**
     * This test method verifies the payment process using different payment options.
     * It uses a data provider to supply the payment option and details for each test case.
     */
    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails){
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("vinoth", "selvaraj", "udemy@gmail.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrderComponent().placeOrder();

        System.out.println(
                "Order Number : " + orderNumber
        );

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    /**
     * This data provider returns an array of payment options and their details.
     * Each entry in the array represents a different payment scenario.
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
