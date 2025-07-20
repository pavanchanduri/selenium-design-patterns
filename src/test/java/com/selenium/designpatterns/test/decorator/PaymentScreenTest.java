package com.selenium.designpatterns.test.decorator;

import com.google.common.util.concurrent.Uninterruptibles;
import com.selenium.designpatterns.decorator.PaymentScreenPage;
import com.selenium.designpatterns.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static com.selenium.designpatterns.test.decorator.PaymentDecorators.*;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreenPage paymentScreenPage;

    /**
     * This test class demonstrates the use of the Decorator Pattern
     * to enhance the functionality of the PaymentScreenPage.
     * It uses TestNG for testing and Guava's Uninterruptibles for sleep.
     */
    @BeforeTest
    public void setPaymentScreenPage(){
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    /**
     * This test method uses a data provider to run multiple scenarios
     * on the PaymentScreenPage using different decorators.
     * Each scenario is defined as a Consumer that modifies the PaymentScreenPage.
     */
    @Test(dataProvider = "getData")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    /**
     * This data provider returns an array of Consumers that represent
     * different payment scenarios. Each scenario is a combination of
     * decorators applied to the PaymentScreenPage.
     */
    @DataProvider
    public Object[] getData(){
        return new Object[]{
                validCC.andThen(buy).andThen(successfulPurchase),
                freeCoupon.andThen(buy).andThen(successfulPurchase),
                discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
                invalidCC.andThen(buy).andThen(failedPurchase),
                invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
                buy.andThen(failedPurchase)
        };
    }
}
