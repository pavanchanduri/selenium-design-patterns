package com.selenium.designpatterns.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import lombok.NonNull;

public class OrderComponentProxy implements IOrderComponent {

    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGING");
    private IOrderComponent orderComponent;

    /**
     * Constructor for OrderComponentProxy.
     * Initializes the real OrderComponent only if the current environment is not excluded.
     *
     * @param driver the WebDriver instance to be used by the real OrderComponent
     */
    public OrderComponentProxy(@NonNull final WebDriver driver) {
        String currentEnv = System.getProperty("env"); // DEV / QA / PROD / STAGING
        if(!EXCLUDED.contains(currentEnv)){
            this.orderComponent = new OrderComponentReal(driver);
        }
    }

    /**
     * Places an order using the real OrderComponent if it is initialized.
     *
     * @return a string indicating the result of the order placement
     */
    @Override
    public String placeOrder() {
        if(Objects.nonNull(this.orderComponent)){
            return this.orderComponent.placeOrder(); // Delegates to the real OrderComponent
        }
        return "SKIPPED";
    }
}
