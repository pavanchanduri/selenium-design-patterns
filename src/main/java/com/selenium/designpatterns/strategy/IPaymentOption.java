package com.selenium.designpatterns.strategy;

import java.util.Map;

import lombok.NonNull;

/**
 * Interface representing a payment option strategy.
 * Implementations should provide the logic to enter payment information.
 */
public interface IPaymentOption {
    void enterPaymentInformation(@NonNull final Map<String, String> paymentDetails);
}
