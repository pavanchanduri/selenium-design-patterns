package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import lombok.NonNull;

public class EmiratesPage {

    private final WebDriver driver;
    private IFlightSearch flightSearch;
    private final By sessionExpired = By.className("ts-session-expire--link");

    /**
     * Constructor for EmiratesPage.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public EmiratesPage(@NonNull final WebDriver driver){
        this.driver = driver;
    }

    /**
     * Navigates to the Emirates flight search page.
     */
    public void goTo(){
        this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");
        this.driver.findElements(sessionExpired)
                .stream()
                .findFirst()
                .ifPresent(WebElement::click);
    }

    /**
     * Sets the flight search functionality for this page.
     *
     * @param flightSearch the flight search implementation to use
     */
    public void setFlightSearch(IFlightSearch flightSearch){
        this.flightSearch = flightSearch;
        PageFactory.initElements(driver, this.flightSearch);
        this.flightSearch.setDatePicker(PageFactory.initElements(driver, DatePicker.class));
    }

    /**
     * Searches for flights based on the provided search details.
     *
     * @param searchDetails a map containing search parameters such as origin, destination, and dates
     */
    public void searchForFlights(Map<String, String> searchDetails){
        this.flightSearch.search(searchDetails);
    }
}
