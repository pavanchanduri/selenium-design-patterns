package com.udemy.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Base test class for Selenium tests
 * Provides setup and teardown methods for WebDriver
 */
public class BaseTest {

    protected WebDriver driver;

    /**
     * Setup the Chrome WebDriver
     */
    @BeforeTest
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    /**
     * Quit the Chrome WebDriver
     */
    @AfterTest
    public void quitDriver(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }

}
