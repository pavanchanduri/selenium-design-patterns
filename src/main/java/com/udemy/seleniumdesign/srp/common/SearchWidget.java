package com.udemy.seleniumdesign.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;

import lombok.NonNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    /**
     * Represents the search box element on the page.
     * This element is identified by the name attribute "q".
     * It is used to enter search keywords.
     */
    @FindBy(name = "q")
    private WebElement searchBox;

    /**
     * Constructor for SearchWidget
     * Initializes the WebDriverWait and PageFactory elements for the search widget.
     * This constructor is used to create an instance of SearchWidget with the provided WebDriver.
     * @param driver the WebDriver instance to be used for waiting and element initialization
     */
    public SearchWidget(@NonNull final WebDriver driver){
        super(driver);
    }

    /**
     * Enters a keyword into the search box.
     * This method clears the search box and types each character of the keyword with a slight delay
     * to simulate user input. The delay is set to 20 milliseconds between each character.
     * This approach helps in avoiding issues with search suggestions that may appear too quickly.
     * @param keyword the search keyword to be entered
     */
    public void enter(@NonNull final String keyword) {
        this.searchBox.clear();
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
    }

    /**
     * Checks if the search box is displayed on the page.
     * This method waits until the search box is visible and returns true if it is displayed,
     * otherwise it returns false. This is useful for verifying the presence of the search widget
     * before performing any actions on it.
     * @return true if the search box is displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
