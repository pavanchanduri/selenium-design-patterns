package com.selenium.designpatterns.test.factory;

import com.selenium.designpatterns.factory.GoogleFactory;
import com.selenium.designpatterns.factory.GooglePage;
import com.selenium.designpatterns.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.NonNull;

/**
 * Test class for Google search functionality using factory pattern
 * Tests searching in different languages
 */
public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    /**
     * Test searching on Google in different languages
     * Uses data provider to supply different language and keyword combinations
     */
    @Test(dataProvider = "getData")
    public void searchTest(@NonNull final String language, @NonNull final String keyword){
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();
        System.out.println("Result Count : " + resultCount);
    }

    /**
     * Data provider for search tests
     * Provides different language and keyword combinations
     * @return 2D array of language and keyword pairs
     */
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "design patterns"},
                {"SA", "selenium"},
                {"ES", "selenium"}
        };
    }
}
