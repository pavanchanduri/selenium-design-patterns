package com.udemy.seleniumdesign.srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * 
 */
public abstract class AbstractComponent {

    protected WebDriverWait wait;

    /**
     * Constructor for AbstractComponent
     * Initializes the WebDriverWait and PageFactory elements.
     * 
     * @param driver the WebDriver instance to be used for waiting and element initialization
     */
    public AbstractComponent(final WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
