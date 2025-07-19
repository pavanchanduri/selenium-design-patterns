package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.NonNull;

public class UserInformation {

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    /**
     * Constructor to initialize the WebElements using PageFactory.
     *
     * @param driver the WebDriver instance used to initialize the page elements
     */
    public UserInformation(@NonNull final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to enter user details into the form fields.
     *
     * @param fn    the first name of the user
     * @param ln    the last name of the user
     * @param email the email address of the user
     */
    public void enterDetails(@NonNull final String fn, @NonNull final String ln, @NonNull final String email){
        this.firstName.sendKeys(fn);
        this.lastName.sendKeys(ln);
        this.email.sendKeys(email);
    }

}
