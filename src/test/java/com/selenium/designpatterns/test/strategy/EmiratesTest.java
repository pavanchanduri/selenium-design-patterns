package com.selenium.designpatterns.test.strategy;

import com.selenium.designpatterns.emirates.*;
import com.selenium.designpatterns.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EmiratesTest extends BaseTest {

    private EmiratesPage emiratesPage;

    /**
     * This method initializes the EmiratesPage object before running the tests.
     * It is annotated with @BeforeTest to ensure it runs before any test methods.
     */
    @BeforeTest
    public void setPaymentScreen(){
        this.emiratesPage = new EmiratesPage(this.driver);
    }

    /**
     * This test method performs a flight search using different flight search strategies.
     * It uses a data provider to supply different flight search strategies and their corresponding search details.
     *
     * @param flightSearch The flight search strategy to be used.
     * @param searchDetails The details for the flight search.
     */
    @Test(dataProvider = "getData")
    public void paymentTest(IFlightSearch flightSearch, Map<String, String> searchDetails){
        this.emiratesPage.goTo();
        this.emiratesPage.setFlightSearch(flightSearch);
        this.emiratesPage.searchForFlights(searchDetails);
    }

    /**
     * Data provider for flight search tests
     * @return 2D array of flight search strategies and their details
     */
    @DataProvider
    public Object[][] getData(){
        Map<String, String> map = new HashMap<>();
        map.put("departureCity", "Austin (AUS)");
        map.put("arrivalCity", "Houston (IAH)");
        map.put("arrivalCity2", "Las Vegas (LAS)");

        return new Object[][] {
            {new OneWay(), map},
            {new TwoWay(), map},
            {new MultiWay(), map},
        };
    }
}
