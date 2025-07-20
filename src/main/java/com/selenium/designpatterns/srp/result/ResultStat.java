package com.selenium.designpatterns.srp.result;

import com.selenium.designpatterns.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.NonNull;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stat;

    /**
     * Constructor for ResultStat
     * Initializes the WebDriverWait and PageFactory elements for the result stats.
     * This constructor is used to create an instance of ResultStat with the provided WebDriver.
     * @param driver the WebDriver instance to be used for waiting and element initialization
     */
    public ResultStat(@NonNull final WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the text of the result stats element.
     * @return the text content of the result stats element
     */
    public String getStat(){
        return this.stat.getText();
    }

    /**
     * Checks if the result stats element is displayed on the page.
     * @return true if the result stats element is displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.stat.isDisplayed());
    }
}
