package com.selenium.designpatterns.emirates;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatePicker {

    @FindBy(css = "td.ui-datepicker-today")
    private WebElement today;

    @FindBy(css ="td a.ui-state-default")
    private List<WebElement> futureDates;

    /**
     * Selects today's date.
     */
    public void selectToday(){
        this.today.click();
    }

    /**
     * Selects a random future date, skipping the first three available dates.
     */
    public void selectRandomFutureDate(){
        this.futureDates
                .stream()
                .filter(e -> e.isEnabled() && e.isDisplayed())
                .skip(3)
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
