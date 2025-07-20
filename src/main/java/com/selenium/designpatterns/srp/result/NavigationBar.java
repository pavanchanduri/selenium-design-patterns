package com.selenium.designpatterns.srp.result;

import com.selenium.designpatterns.srp.common.AbstractComponent;

import lombok.NonNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "News")
    private WebElement news;

    @FindBy(id = "hdtb-tls")
    private WebElement tools;

    /**
     * Constructor for NavigationBar
     * Initializes the WebDriverWait and PageFactory elements for the navigation bar.
     * This constructor is used to create an instance of NavigationBar with the provided WebDriver.
     * @param driver the WebDriver instance to be used for waiting and element initialization
     */
    public NavigationBar(@NonNull final WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks on the "Images" link in the navigation bar.
     * This method allows the user to navigate to the images section of the search results.
     */
    public void goToImages(){
        this.images.click();
    }

    /**
     * Clicks on the "News" link in the navigation bar.
     * This method allows the user to navigate to the news section of the search results.
     */
    public void goToNews(){
        this.news.click();
    }

    /**
     * Clicks on the "Tools" link in the navigation bar.
     * This method allows the user to access additional tools for filtering search results.
     */
    public void clickOnTools(){
        this.tools.click();
    }

    /**
     * Checks if the navigation bar is displayed.
     * This method waits until the navigation bar is visible on the page.
     * @return true if the navigation bar is displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.bar.isDisplayed());
    }
}
