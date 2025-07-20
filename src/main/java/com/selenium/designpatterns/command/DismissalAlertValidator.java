package com.selenium.designpatterns.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lombok.RequiredArgsConstructor;

/**
 * This class validates the dismissal of an alert by clicking a close button.
 * It checks if the alert is displayed before and after clicking the close button.
 */
@RequiredArgsConstructor // Lombok annotation to generate constructor with required arguments
public class DismissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;

    /**
     * Validates the dismissal of the alert.    
     * It checks if the alert is displayed before clicking the close button,
     * clicks the close button, and then checks if the alert is no longer displayed.
     * 
     * @return true if the alert was displayed before clicking the close button
     *         and is not displayed after clicking the close button; false otherwise.
     */
    @Override
    public boolean validate() {
        boolean result1 = this.dismissalAlert.isDisplayed(); //true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean result2 = false;
        try{
        	result2 = !this.dismissalAlert.isDisplayed(); //false;
        }catch(Exception e){
        	//skip
        }
        return result1 && result2;
    }
}
