package com.udemy.seleniumdesign.proxy;

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

    public static IPaymentOption get(@NonNull final String option){
        return MAP.get(option).get();
    }

}
