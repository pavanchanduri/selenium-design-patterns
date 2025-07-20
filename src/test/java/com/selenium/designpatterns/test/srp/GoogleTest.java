package com.selenium.designpatterns.test.srp;

import com.selenium.designpatterns.srp.main.GoogleMainPage;
import com.selenium.designpatterns.srp.result.GoogleResultPage;
import com.selenium.designpatterns.test.BaseTest;

import lombok.NonNull;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    /**
     * Initialize page objects for testing
     */
    @BeforeTest
    public void setupPages(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    /**
     * Test the Google search workflow
     * @param keyword the search keyword
     * @param index the suggestion index
     */
    @Test(dataProvider = "getData")
    public void googleWorkflow(@NonNull final String keyword, final int index){

        //String keyword = "selenium webdriver";
        //int index  = 3;

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        googleResultPage.getNavigationBar().clickOnTools();

        System.out.println(
                googleResultPage.getResultStat().getStat()
        );

    }

    /**
     * Data provider for Google search test
     * @return
     */
    @DataProvider
    public Object[][] getData(){

        return new Object[][]{
                {"selenium", 3},
                {"docker", 2},
                {null, 0}
        };
    }
}
