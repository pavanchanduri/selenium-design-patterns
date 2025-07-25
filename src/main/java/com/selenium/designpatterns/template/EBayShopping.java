package com.selenium.designpatterns.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import lombok.NonNull;

public class EBayShopping extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id="gh-ac")
    private WebElement searchBox;

    @FindBy(id="gh-btn")
    private WebElement searchBtn;

    @FindBy(css = "div.s-item__info a")
    private WebElement item;

    @FindBy(id = "prcIsum")
    private WebElement price;

    /**
     * Constructor for EBayShopping.
     *
     * @param driver the WebDriver instance
     * @param product the product to search for
     */
    public EBayShopping(@NonNull final WebDriver driver, @NonNull final String product){
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Constructor for EBayShopping with default product.
     *
     * @param driver the WebDriver instance
     */
    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    /**
     * Constructor for EBayShopping with default product.
     */
    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    /**
     * Selects the first product from the search results.
     */
    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }

    /**
     * Retrieves the price of the selected product.
     */
    @Override
    public void buy() {
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println(
                this.price.getText()
        );
    }
}
