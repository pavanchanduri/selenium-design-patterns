package com.selenium.designpatterns.test.decorator;

import com.selenium.designpatterns.decorator.DashboardPage;
import com.selenium.designpatterns.test.BaseTest;

import lombok.NonNull;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    /**
     * Sets up the DashboardPage instance before running the tests.
     * This method initializes the dashboardPage object with the WebDriver instance.
     * It is annotated with @BeforeTest to ensure it runs before any test methods in this class.
     * The dashboardPage will be used to test different user roles on the dashboard.
     */
    @BeforeTest
    public void setDashboardPage(){
        this.dashboardPage = new DashboardPage(driver);
    }

    /**
     * Tests the functionality of the DashboardPage for different user roles.
     * It uses a data provider to supply different role-specific actions to be tested.
     * Each role action is executed on the dashboardPage instance.
     *
     * @param role A Consumer that takes a DashboardPage and performs actions based on user roles.
     */
    @Test(dataProvider = "getData")
    public void roleTest(@NonNull final Consumer<DashboardPage> role){
        this.dashboardPage.goTo();
        role.accept(this.dashboardPage);
    }

    /**
     * Provides test data for different user roles on the DashboardPage.
     * Each role is represented as a Consumer that takes a DashboardPage and performs actions.
     *
     * @return An array of Objects containing role-specific actions.
     */
    @DataProvider
    public Object[] getData(){
        return new Object[]{
             Decorators.guestPage,
             Decorators.suPage,
             Decorators.adminPage
        };
    }



}
