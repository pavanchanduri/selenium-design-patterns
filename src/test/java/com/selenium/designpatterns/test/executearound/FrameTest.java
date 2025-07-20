package com.selenium.designpatterns.test.executearound;

import com.selenium.designpatterns.executearound.MainPage;
import com.selenium.designpatterns.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    /**
     * This method initializes the MainPage object before running the tests.
     * It is annotated with @BeforeTest to ensure it runs before any test methods.
     */
    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    /**
     * The test uses the Execute Around pattern to interact with the frames.
     * The test fills out the first name in Frame A, the address in Frame C,
     * and the message in Frame B.
     * The Execute Around pattern allows for cleaner and more maintainable code
     * by encapsulating the logic for interacting with the frames in a single method.
     * This way, the test can focus on the high-level actions without worrying about
     * the details of switching between frames.
     */
    @Test
    public void frameTest() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setMessage("I am going to fill text area");
        });
        this.mainPage.onFrameC(c -> c.setAddress("address for FrameC"));
        this.mainPage.onFrameB(b -> b.setMessage("this is for Frame B"));
    }
}
