package com.udemy.seleniumdesign.srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.NonNull;
import java.time.Duration;

/**
 * AbstractComponent serves as a base class for page components in the Selenium Design SRP project.
 * It provides common functionality such as waiting for elements and initializing PageFactory.
 */
public abstract class AbstractComponent {

    protected WebDriverWait wait;

    /**
     * Constructor for AbstractComponent
     * Initializes the WebDriverWait and PageFactory elements.
     * 
     * @param driver the WebDriver instance to be used for waiting and element initialization
     */
    public AbstractComponent(@NonNull final WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for the component to be displayed.
     * This method should be implemented by subclasses to define specific waiting logic.
     */
    public abstract boolean isDisplayed();
}
