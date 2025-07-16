package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import lombok.NonNull;

public class AmazonResultsPage {

    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@class,'a-link-normal')]")
    private WebElement item;

    /**
     * Constructor for AmazonResultsPage.
     *
     * @param driver the WebDriver instance to use for this page
     */
    public AmazonResultsPage(@NonNull final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects the first product from the search results.
     */
    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }
}
