package com.selenium.designpatterns.test.decorator;

import com.selenium.designpatterns.decorator.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentDecorators {

        /**
         * Decorators for PaymentScreenPage actions.
         * These actions can be used to create a sequence of operations on the PaymentScreenPage.
         * Each action is a Consumer that takes a PaymentScreenPage instance and performs an operation.
         * This allows for flexible and reusable test scenarios.        
         */
        public static final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromocode("FREEUDEMY");
        public static final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromocode("PARTIALUDEMY");
        public static final Consumer<PaymentScreenPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
        public static final Consumer<PaymentScreenPage> invalidCC = (p) -> p.enterCC("4111111111111112", "2023", "123");
        public static final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();

        /**
         * Decorators for verifying the status of the payment.
         * These actions assert the status of the PaymentScreenPage after performing a purchase.
         * They can be used to validate whether the purchase was successful or failed.
         * Each action is a Consumer that takes a PaymentScreenPage instance and checks its status.
         * This allows for easy verification of the payment process in tests.
         */
        public static final Consumer<PaymentScreenPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
        public static final Consumer<PaymentScreenPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");

}
