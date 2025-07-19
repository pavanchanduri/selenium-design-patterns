package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.NonNull;

public class AmazonSearchPage {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchBtn;

    /**
     * Constructor for AmazonSearchPage
     * @param driver
     */
    public AmazonSearchPage(@NonNull final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to Amazon's homepage
     */
    public void goTo() {
        this.driver.get("https://www.amazon.com/");
    }

    /**
     * Search for a product on Amazon
     * @param product the product to search for
     */
    public void search(@NonNull final String product) {
        this.searchBox.sendKeys(product);
        this.searchBtn.click();
    }

}
