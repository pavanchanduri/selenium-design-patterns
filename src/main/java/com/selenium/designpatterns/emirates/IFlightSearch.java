package com.selenium.designpatterns.emirates;

import java.util.Map;
import lombok.NonNull;

/**
 * Interface for flight search functionality.
 * Provides methods to search for flights and set a date picker.
 */
public interface IFlightSearch {
    void search(@NonNull final Map<String, String> searchDetails);
    void setDatePicker(@NonNull final DatePicker datePicker);
}
