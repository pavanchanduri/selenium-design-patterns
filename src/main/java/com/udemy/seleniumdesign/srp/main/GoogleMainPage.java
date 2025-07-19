package com.udemy.seleniumdesign.srp.main;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;

import lombok.NonNull;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    private WebDriver driver;
    private @Getter SearchWidget searchWidget; 
    private @Getter SearchSuggestion searchSuggestion;

    /**
     * Constructor for GoogleMainPage.
     * Initializes the WebDriver and the page elements using PageFactory.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public GoogleMainPage(@NonNull final WebDriver driver){
        this.driver = driver;
        this.searchWidget = new SearchWidget(driver);
        this.searchSuggestion = new SearchSuggestion(driver);
    }

    /**
     * Navigates to the Google main page.
     * This method uses the WebDriver to open the Google homepage.
     */
    public void goTo(){
        this.driver.get("https://www.google.com");
    }
}
