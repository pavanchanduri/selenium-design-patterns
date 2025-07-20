package com.selenium.designpatterns.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import lombok.NonNull;

public class PaymentOptionFactory {

    private static final Supplier<IPaymentOption> CC = () -> new CreditCard();
    private static final Supplier<IPaymentOption> NB = () -> new NetBanking();

    private static final Map<String, Supplier<IPaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }

    /**
     * Factory method to get the payment option based on the input string.
     * This method uses a map to retrieve the appropriate payment option
     * implementation based on the provided key.
     * @param option - the key to identify the payment option
     *                (e.g., "CC" for Credit Card, "NB" for NetBanking)
     * @return IPaymentOption - an instance of the requested payment option i.e., new CreditCard() or new NetBanking()
     */
    public static IPaymentOption get(@NonNull final String option){
        return MAP.get(option).get(); 
    }
}
