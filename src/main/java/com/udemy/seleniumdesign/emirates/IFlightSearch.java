package com.udemy.seleniumdesign.emirates;

import java.util.Map;

public interface IFlightSearch {
    void search(Map<String, String> searchDetails);
    void setDatePicker(DatePicker datePicker);
}
