package com.udemy.seleniumdesign.template;

public abstract class ShoppingTemplate {

    public abstract void launchSite();
    public abstract void searchForProduct();
    public abstract void selectProduct();
    public abstract void buy();

    /**
     * Template method defining the skeleton of the shopping process.
     * This method should not be overridden by subclasses.
     * It calls the abstract methods in a specific order to complete the shopping process.
     * Subclasses will provide the implementation for each step.
     */
    public void shop() {
        launchSite();
        searchForProduct();
        selectProduct();
        buy();
    }
}
