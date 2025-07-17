package com.udemy.seleniumdesign.proxy;

import java.util.Map;

public interface IPaymentOption {
    void enterPaymentInformation(Map<String, String> paymentDetails);
}
