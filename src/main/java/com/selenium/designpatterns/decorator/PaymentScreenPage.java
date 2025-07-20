package com.selenium.designpatterns.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.NonNull;

public class PaymentScreenPage {

    private final WebDriver driver;

    @FindBy(id="coupon")
    private WebElement coupon;

    @FindBy(id="couponbtn")
    private WebElement couponbtn;

    @FindBy(id="cc")
    private WebElement cc;

    @FindBy(id="year")
    private WebElement year;

    @FindBy(id="cvv")
    private WebElement cvv;

    @FindBy(id="buy")
    private WebElement buy;

    @FindBy(id="status")
    private WebElement status;

    /**
     * Constructor for PaymentScreenPage
     * @param driver WebDriver instance to interact with the browser
     */
    public PaymentScreenPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the payment screen URL.
     */
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    /**
     * Applies a promocode to the payment screen.
     * @param promocode The promocode to apply.
     */
    public void applyPromocode(@NonNull final String promocode){
        this.coupon.sendKeys(promocode);
        this.couponbtn.click();
    }

    /**
     * Enters credit card details for payment.
     * @param cc Credit card number.
     * @param year Expiration year of the credit card.
     * @param cvv CVV code of the credit card.
     */
    public void enterCC(@NonNull final String cc, @NonNull final String year, @NonNull final String cvv){
        this.cc.sendKeys(cc);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }

    /**
     * Clicks the buy button to complete the purchase.
     */
    public void buyProduct(){
        this.buy.click();
    }

    /**
     * Retrieves the status message after attempting to buy a product.
     * @return The status message as a trimmed string.
     */
    public String getStatus(){
        return this.status.getText().trim();
    }

}
