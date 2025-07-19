package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.NonNull;

public class OrderComponentReal implements IOrderComponent {

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    /**
     * Constructor to initialize the WebElements using PageFactory.
     *
     * @param driver the WebDriver instance used to initialize the page elements
     */
    public OrderComponentReal(@NonNull final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Places an order by clicking the buy button and returns the order number.
     *
     * @return the order number as a String
     */
    @Override
    public String placeOrder() {
        this.buyNow.click();
        return this.orderNumber.getText();
    }
}
