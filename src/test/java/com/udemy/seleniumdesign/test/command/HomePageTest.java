package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    /**
     * This test is to validate the HomePage functionality.
     * It checks if all the elements on the home page are functioning correctly.
     */
    @BeforeTest
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

    /**
     * This test validates the home page by checking if all the element validators return true.
     * It uses parallel processing to validate each element validator.
     */
    @Test
    public void homePageTest(){
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }

}
