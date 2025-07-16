package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import lombok.NonNull;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    //notifications
    @FindBy(xpath = "//div[contains(@class, 'jq-icon-info')]")
    private WebElement infoAlert;

    @FindBy(xpath = "//div[contains(@class, 'jq-icon-warning')]")
    private WebElement warnAlert;

    @FindBy(xpath = "//div[contains(@class, 'jq-icon-success')]")
    private WebElement successAlert;

    @FindBy(xpath = "//div[contains(@class, 'jq-icon-error')]")
    private WebElement dangerAlert;

    //dismissal alert
    @FindBy(xpath = "//h4[contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class,'alert-info')]")
    private WebElement dismissInfoAlert;

    @FindBy(xpath = "//h4[contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class,'alert-success')]")
    private WebElement dismissSuccessAlert;

    @FindBy(xpath = "//h4[contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class,'alert-danger')]")
    private WebElement dismissDangerAlert;

    @FindBy(xpath = "//h4[contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class,'alert-warning')]")
    private WebElement dismissWarnAlert;

    /**
     * Constructor for the HomePage class.
     * @param driver the WebDriver instance used to interact with the web page.
     */
    public HomePage(@NonNull final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the home page of the application.
     * This method loads the home page URL and waits until the info button is displayed.
     */
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
        this.wait.until((d) -> this.infoBtn.isDisplayed());
    }

    /**
     * Returns a list of element validators for the home page.
     * These validators are used to check the state of various elements on the page.
     * @return a list of ElementValidator instances.
     */
    public List<ElementValidator> getElementValidators(){
        return Arrays.asList(
                //notification
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(dangerBtn, dangerAlert),
                //dismiss
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissWarnAlert),
                new DismissalAlertValidator(dismissDangerAlert)
        );
    }

}
