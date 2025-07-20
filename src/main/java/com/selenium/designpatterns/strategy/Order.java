package com.selenium.designpatterns.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.NonNull;

public class Order {

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    /**
     * Constructor to initialize the PageFactory elements
     * @param driver WebDriver instance
     */
    public Order(@NonNull final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to place an order
     * @return the order number as a String
     */
    public String placeOrder(){
        this.buyNow.click();
        return this.orderNumber.getText();
    }

}
