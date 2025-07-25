package com.selenium.designpatterns.test;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions options = new ChromeOptions();
        // This option prevents the captcha feature of chrome from being triggered
        options.addArguments("--disable-blink-features=AutomationControlled");
        this.driver = new ChromeDriver(options);
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
