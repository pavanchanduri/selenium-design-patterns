package com.selenium.designpatterns.factory;

import com.google.common.util.concurrent.Uninterruptibles;

import lombok.NonNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "#rso div")
    private List<WebElement> results;

    /**
     * Constructor for GoogleEnglish
     * Initializes the WebDriver and waits
     * @param driver WebDriver instance to interact with the browser
     */
    public GoogleEnglish(@NonNull final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Launch the Google homepage
     * This method navigates the WebDriver to the Google homepage.
     * It is used to prepare the browser for searching.
     */
    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    /**
     * Search for a keyword
     * This method takes a keyword, types it into the search box,
     * and clicks the search button to perform a search.
     * @param keyword The search term to be entered in the search box
     */
    @Override
    public void search(@NonNull final String keyword) {
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.wait.until((d) -> this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    /**
     * Get the count of search results
     * This method waits for the search results to be displayed
     * and returns the count of the results found.
     * @return The number of search results displayed
     */
    @Override
    public int getResultsCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}
