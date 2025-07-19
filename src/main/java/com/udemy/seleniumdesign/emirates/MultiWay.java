package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import lombok.NonNull;

public class MultiWay implements IFlightSearch {

    @FindBy(id = "dvRadioMulti")
    private WebElement multiwayRadio;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom1-suggest")
    private WebElement departureCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom2-suggest")
    private WebElement departureCity2;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo1-suggest")
    private WebElement arrivalCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo2-suggest")
    private WebElement arrivalCity2;

    @FindBy(id = "ctl00_c_CtWNW_txtD1")
    private WebElement departureDate;

    @FindBy(id = "ctl00_c_CtWNW_txtD2")
    private WebElement departureDate2;

    private @NonNull DatePicker datePicker;

    /**
     * Search for multi-way flights based on the provided search details.
     * @param searchDetails A map containing the search parameters:
     *                      "departureCity", "arrivalCity", "arrivalCity2"
     *                      "departureDate", "departureDate2".
     *                      The departureDate and departureDate2 are selected using the DatePicker.
     */
    @Override
    public void search(@NonNull final Map<String, String> searchDetails) {
        this.multiwayRadio.click();
        this.departureCity.sendKeys(searchDetails.get("departureCity"));
        this.arrivalCity.sendKeys(searchDetails.get("arrivalCity"));
        this.departureDate.click();
        this.datePicker.selectToday();
        this.arrivalCity2.sendKeys(searchDetails.get("arrivalCity2"));
        this.departureDate2.click();
        this.datePicker.selectRandomFutureDate();
    }

    /**
     * Selects the departure city for the first leg of the multi-way flight.
     * @param departureCity The city from which the flight departs.
     */
    @Override
    public void setDatePicker(@NonNull final DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}
