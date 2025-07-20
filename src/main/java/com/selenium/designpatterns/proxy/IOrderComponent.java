package com.selenium.designpatterns.proxy;

/**
 * OrderComponent interface defines the contract for placing orders.
 * Implementations of this interface will provide the actual order placement logic.
 */
public interface IOrderComponent {
    String placeOrder();
}
