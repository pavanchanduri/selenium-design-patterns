package com.udemy.seleniumdesign.srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.NonNull;
import java.util.List;

public class SearchSuggestion extends AbstractComponent {

    /**
     * Represents the list of search suggestions displayed in the search bar.
     * Each suggestion is represented by a WebElement.
     * The suggestions are identified by the CSS selector "li.sbct".
     */
    @FindBy(css = "li.sbct")
    private List<WebElement> suggestions;

    /**
     * Constructor for SearchSuggestion
     * Initializes the WebDriverWait and PageFactory elements for search suggestions.
     * This constructor is used to create an instance of SearchSuggestion with the provided WebDriver.
     * @param driver the WebDriver instance to be used for waiting and element initialization
     */
    public SearchSuggestion(@NonNull final WebDriver driver){
        super(driver);
    }

    /**
     * Clicks on a search suggestion based on its index.
     * The index is 1-based, meaning the first suggestion has an index of 1.
     * This method allows the user to select a specific suggestion from the list.
     * @param index the index of the suggestion to click on (1-based index)
     */
    public void clickSuggestionByIndex(final int index){
        this.suggestions.get(index - 1).click();
    }

    /**
     * Checks if the search suggestions are displayed.
     * This method waits until there are more than 5 suggestions available.
     * It returns true if the suggestions are displayed, otherwise false.
     * @return true if suggestions are displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.suggestions.size() > 5);
    }
}
