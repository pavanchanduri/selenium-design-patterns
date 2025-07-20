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
        private static final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromocode("FREEUDEMY");
        private static final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromocode("PARTIALUDEMY");
        private static final Consumer<PaymentScreenPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
        private static final Consumer<PaymentScreenPage> invalidCC = (p) -> p.enterCC("4111111111111112", "2023", "123");
        private static final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();

        /**
         * Decorators for verifying the status of the payment.
         * These actions assert the status of the PaymentScreenPage after performing a purchase.
         * They can be used to validate whether the purchase was successful or failed.
         * Each action is a Consumer that takes a PaymentScreenPage instance and checks its status.
         * This allows for easy verification of the payment process in tests.
         */
        private static final Consumer<PaymentScreenPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
        private static final Consumer<PaymentScreenPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");

        /**
         * Test cases that combine the decorators to create specific payment scenarios.
         * Each test case is a Consumer that applies a sequence of decorators to the PaymentScreenPage.
         * This allows for easy creation of complex test scenarios by combining simple actions.
         * The test cases can be used in the PaymentScreenTest class to run multiple scenarios.
         */
        public static final Consumer<PaymentScreenPage> testcase1 = validCC.andThen(buy).andThen(successfulPurchase);
        public static final Consumer<PaymentScreenPage> testcase2 = freeCoupon.andThen(buy).andThen(successfulPurchase);
        public static final Consumer<PaymentScreenPage> testcase3 = discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase);
        public static final Consumer<PaymentScreenPage> testcase4 = invalidCC.andThen(buy).andThen(failedPurchase);
        public static final Consumer<PaymentScreenPage> testcase5 = discountedCoupon.andThen(invalidCC).andThen(buy).andThen(failedPurchase);
        public static final Consumer<PaymentScreenPage> testcase6 = buy.andThen(failedPurchase);
}
