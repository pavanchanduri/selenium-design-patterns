package com.selenium.designpatterns.command;

import com.google.common.util.concurrent.Uninterruptibles;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor // Using Lombok to generate constructor
public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    /**
     * Validates the notification by clicking the button and checking the notification's visibility.
     * This method clicks the button to trigger the notification,
     * then waits for a specified time to check if the notification appears and disappears.
     * It returns true if the notification appears after clicking the button
     * and then disappears after a delay.
     * 
     * @return true if the notification appears and then disappears after a delay, false otherwise.
     */
    @Override
    public boolean validate() {
        this.button.click();
        boolean appearanceState = this.notification.isDisplayed(); //true
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean disappearanceState = !this.notification.isDisplayed(); // false
        return appearanceState && disappearanceState;
    }
}
