package com.udemy.seleniumdesign.executearound;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.NonNull;

public class FrameC {

    @FindBy(name="fn")
    private WebElement firstName;

    @FindBy(name="ln")
    private WebElement lastName;

    @FindBy(name="addr")
    private WebElement address;

    @FindBy(id="area")
    private WebElement message;

    /**
     * Sets the first name in the form.
     * @param firstName
     */
    public void setFirstName(@NonNull final String firstName) {
        this.firstName.sendKeys(firstName);
    }

    /**
     * Sets the last name in the form.
     * @param lastName
     */
    public void setLastName(@NonNull final String lastName) {
        this.lastName.sendKeys(lastName);
    }

    /**
     * Sets the address in the form.
     * @param address
     */
    public void setAddress(@NonNull final String address) {
        this.address.sendKeys(address);
    }

    /**
     * Sets the message in the form.
     * @param message
     */
    public void setMessage(@NonNull final String message) {
        this.message.sendKeys(message);
    }
}
