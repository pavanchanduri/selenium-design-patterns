package com.udemy.seleniumdesign.proxy;

import java.util.Map;
import lombok.NonNull;

/**
 * Interface representing a payment option.
 * Classes implementing this interface should provide
 * the method to enter payment information.
 */
public interface IPaymentOption {
    void enterPaymentInformation(@NonNull final Map<String, String> paymentDetails);
}
