package com.udemy.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import lombok.NonNull;

public class PaymentOptionFactory {

    /**
     * Map to hold the payment options and their corresponding suppliers
     * This map is used to retrieve the appropriate payment option based on the input string.
     * The keys are the payment option identifiers (e.g., "CC" for Credit Card, "NB" for Net Banking),
     * and the values are suppliers that create instances of the corresponding payment option classes.
     */
    private static final Supplier<IPaymentOption> CC = () -> new CreditCard();
    private static final Supplier<IPaymentOption> NB = () -> new NetBanking();

    private static final Map<String, Supplier<IPaymentOption>> MAP = new HashMap<>();

    /**
     * Static block to initialize the payment option map
     */
    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }

    /**
     * Factory method to get the payment option based on the provided option string
     * @param option the payment option as a String
     * @return an instance of IPaymentOption
     */
    public static IPaymentOption get(@NonNull final String option){
        return MAP.get(option).get();
    }

}
