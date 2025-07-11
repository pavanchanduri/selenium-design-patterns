package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.NonNull;

class GoogleES extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    /**
     * Constructor for GoogleES
     * Initializes the WebDriver and waits  
     * @param driver WebDriver instance to interact with the browser
     */
    public GoogleES(@NonNull final WebDriver driver) {
        super(driver);
    }

    /**
     * Launch the Google homepage in Spanish
     * This method navigates the WebDriver to the Google Spanish homepage
     * and clicks on the language selection element to switch to Spanish.
     * It is used to prepare the browser for searching in Spanish.
     */
    @Override
    public void launchSite(){
        this.driver.get("https://www.google.com/?&hl=es");
    }

}
