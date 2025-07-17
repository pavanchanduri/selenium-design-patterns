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

    public UserInformation(@NonNull final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void enterDetails(@NonNull final String fn, @NonNull final String ln, @NonNull final String email){
        this.firstName.sendKeys(fn);
        this.lastName.sendKeys(ln);
        this.email.sendKeys(email);
    }

}
