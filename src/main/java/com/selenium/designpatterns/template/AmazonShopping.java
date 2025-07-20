package com.selenium.designpatterns.template;

import com.selenium.designpatterns.template.pages.AmazonProductDescriptionPage;
import com.selenium.designpatterns.template.pages.AmazonResultsPage;
import com.selenium.designpatterns.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;

import lombok.NonNull;

public class AmazonShopping extends ShoppingTemplate {

    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;

    /**
     * Constructor for AmazonShopping.
     *
     * @param driver  the WebDriver instance
     * @param product the product to search for
     */
    public AmazonShopping(@NonNull final WebDriver driver, @NonNull final String product){
        this.product = product;
        this.amazonSearchPage = new AmazonSearchPage(driver);
        this.amazonResultsPage = new AmazonResultsPage(driver);
        this.amazonProductDescriptionPage = new AmazonProductDescriptionPage(driver);
    }

    /**
     * Constructor for AmazonShopping with a default product.
     *
     * @param driver the WebDriver instance
     */
    @Override
    public void launchSite() {
        this.amazonSearchPage.goTo();
    }

    /**
     * Searches for a product on Amazon.
     */
    @Override
    public void searchForProduct() {
        this.amazonSearchPage.search(this.product);
    }

    /**
     * Selects a product from the search results.
     */
    @Override
    public void selectProduct() {
        this.amazonResultsPage.selectProduct();
    }

    /**
     * Adds the selected product to the cart.
     */
    @Override
    public void buy() {
        this.amazonProductDescriptionPage.buy();
    }
}
