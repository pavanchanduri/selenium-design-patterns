package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import lombok.NonNull;

public class AmazonProductDescriptionPage {

    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='corePrice_feature_div']/descendant::span[@class='a-offscreen']")
    private WebElement price;

    /**
     * Constructor for AmazonProductDescriptionPage.
     *
     * @param driver the WebDriver instance to use for this page
     */
    public AmazonProductDescriptionPage(@NonNull final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to buy the product by waiting for the price to be displayed.
     * It prints the price of the product to the console.
     */
    public void buy() {
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println(
                this.price.getText()
        );
    }

}
