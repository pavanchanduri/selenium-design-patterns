package com.selenium.designpatterns.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import lombok.Getter;
import lombok.NonNull;

public class DashboardPage {

    private @Getter WebDriver driver;

    @FindBy(id = "role")
    private WebElement role;

    @FindBy(css ="div.guest")
    private @Getter List<WebElement> guestComponents;

    @FindBy(css ="div.superuser")
    private @Getter List<WebElement> superUserComponents;

    @FindBy(css ="div.admin")
    private @Getter List<WebElement> adminComponents;

    /**
     * Constructor for DashboardPage.
     * Initializes the WebDriver and PageFactory elements.
     *
     * @param driver the WebDriver instance to use for this page
     */
    public DashboardPage(@NonNull final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the dashboard page.
     */
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    /**
     * Selects a role from the dropdown.
     *
     * @param role the role to select, must not be null
     */
    public void selectRole(@NonNull final String role){
        Select select = new Select(this.role);
        select.selectByValue(role);
    }
}
