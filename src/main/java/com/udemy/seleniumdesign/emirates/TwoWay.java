package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import lombok.NonNull;

public class TwoWay implements IFlightSearch {

    @FindBy(id = "Div1")
    private WebElement twowayRadio;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement departureCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement arrivalCity;

    @FindBy(id = "ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDate;

    @FindBy(id = "dvReturnDate")
    private WebElement returnDate;

    private DatePicker datePicker;

    /**
     * Search for a two-way flight based on the provided search details.
     * @param searchDetails A map containing the search parameters such as departure city and arrival city.
     *                      The departure date is set to today, and the return date is set to a random future date.
     *                      Expected keys in the map: "departureCity", "arrivalCity".
     */
    @Override
    public void search(@NonNull final Map<String, String> searchDetails) {
        this.twowayRadio.click();
        this.departureCity.sendKeys(searchDetails.get("departureCity"));
        this.departureDate.click();
        this.datePicker.selectToday();
        this.arrivalCity.sendKeys(searchDetails.get("arrivalCity"));
        this.returnDate.click();
        this.datePicker.selectRandomFutureDate();
    }

    /**
     * Sets the DatePicker instance to be used for selecting dates.
     * @param datePicker The DatePicker instance to set.
     */
    @Override
    public void setDatePicker(@NonNull final DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}
