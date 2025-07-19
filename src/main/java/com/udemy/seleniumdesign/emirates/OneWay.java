package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import lombok.NonNull;

public class OneWay implements IFlightSearch {

    @FindBy(id = "dvRadioOneway")
    private WebElement onewayRadio;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement departureCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement arrivalCity;

    @FindBy(id = "ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDate;

    private DatePicker datePicker;

    /**
     * Search for a one-way flight using the provided search details.
     * @param searchDetails A map containing the search parameters such as departure city, arrival city, and date.
     * The keys in the map should be "departureCity", "arrivalCity", and the date is handled by the DatePicker.
     */
    @Override
    public void search(@NonNull final Map<String, String> searchDetails) {
        this.onewayRadio.click();
        this.departureCity.sendKeys(searchDetails.get("departureCity"));
        this.arrivalCity.sendKeys(searchDetails.get("arrivalCity"));
        this.departureDate.click();
        this.datePicker.selectToday();
    }

    /**
     * Set the DatePicker instance to be used for selecting dates.
     * @param datePicker The DatePicker instance to set.
     */
    @Override
    public void setDatePicker(@NonNull final DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}
