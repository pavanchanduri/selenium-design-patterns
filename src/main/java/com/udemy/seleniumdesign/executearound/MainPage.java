package com.udemy.seleniumdesign.executearound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;
import lombok.NonNull;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id="a")
    private WebElement a;

    @FindBy(id="b")
    private WebElement b;

    @FindBy(id="c")
    private WebElement c;

    private FrameA frameA;
    private FrameB frameB;
    private FrameC frameC;

    /**
     * Constructor for MainPage that initializes the WebDriver and PageFactory elements.
     * It also initializes FrameA, FrameB, and FrameC using the same WebDriver instance.
     * @param driver - the WebDriver instance to be used for this page
     */
    public MainPage(@NonNull WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.frameA = PageFactory.initElements(driver, FrameA.class);
        this.frameB = PageFactory.initElements(driver, FrameB.class);
        this.frameC = PageFactory.initElements(driver, FrameC.class);
    }

    /**
     * Navigates to the main page URL.
     * This method uses the WebDriver to open the specified URL.
     */
    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    /**
     * Executes the consumer on FrameA after switching to it.
     * After execution, it switches back to the default content.
     * This allows for operations on FrameA without
     * needing to manage the switching logic outside this method.
     * @param consumer - the consumer to execute on FrameA
     */
    public void onFrameA(@NonNull final Consumer<FrameA> consumer) {
        this.driver.switchTo().frame(a);
        consumer.accept(this.frameA);
        this.driver.switchTo().defaultContent();
    }

    /**
     * Executes the consumer on FrameB after switching to it.
     * After execution, it switches back to the default content.
     * This allows for operations on FrameB without
     * needing to manage the switching logic outside this method.
     * @param consumer - the consumer to execute on FrameB
     */
    public void onFrameB(@NonNull final Consumer<FrameB> consumer) {
        this.driver.switchTo().frame(b);
        consumer.accept(this.frameB);
        this.driver.switchTo().defaultContent();
    }

    /**
     * Executes the consumer on FrameC after switching to it.
     * After execution, it switches back to the default content.
     * This allows for operations on FrameC without
     * needing to manage the switching logic outside this method.
     * @param consumer - the consumer to execute on FrameC
     */
    public void onFrameC(@NonNull final Consumer<FrameC> consumer) {
        this.driver.switchTo().frame(c);
        consumer.accept(this.frameC);
        this.driver.switchTo().defaultContent();
    }
}
