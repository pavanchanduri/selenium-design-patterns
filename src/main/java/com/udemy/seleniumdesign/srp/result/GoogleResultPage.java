package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;

import lombok.Getter;
import lombok.NonNull;

import org.openqa.selenium.WebDriver;

@Getter
public class GoogleResultPage {

    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    /**
     * Constructor for GoogleResultPage.
     * Initializes the page components using the provided WebDriver.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public GoogleResultPage(@NonNull final WebDriver driver){
        this.searchWidget = new SearchWidget(driver);
        this.searchSuggestion = new SearchSuggestion(driver);
        this.navigationBar = new NavigationBar(driver);
        this.resultStat = new ResultStat(driver);
    }
}
