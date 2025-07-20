package com.selenium.designpatterns.test.decorator;

import com.selenium.designpatterns.decorator.DashboardPage;

import lombok.NonNull;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    /**
     * This class contains the ingredients for the decorator pattern test.
     * It provides a set of consumers that can be used to build different user role pages.
     * Each consumer applies a specific action to the DashboardPage, such as selecting a role or checking component visibility.
     */
    private static void shouldDisplay(@NonNull final List<WebElement> elements){
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    /**
     * This method checks that the provided list of WebElements is not displayed.
     * It asserts that each element in the list is not displayed.
     *
     * @param elements List of WebElements to check
     */
    private static void shouldNotDisplay(@NonNull final List<WebElement> elements){
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    /**
     * This class contains a set of consumers that define the expected state of the DashboardPage
     * for different user roles. Each consumer checks the visibility of specific components
     * based on the user role selected.
     * It also includes role selection consumers that set the user role on the DashboardPage.
     * The consumers can be combined to create specific user role pages.    
     */
    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> suComponentPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> suComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    
    /**
     * This section defines consumers for selecting user roles on the DashboardPage.
     * Each consumer applies a specific role selection action to the DashboardPage.
     * These consumers can be used to set the user role before checking the visibility of components.
     * The role selection consumers can be combined with component visibility checks to create
     * specific user role pages.
     */
    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> suSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

    /**
     * This section defines the final consumers that combine role selection and component visibility checks.
     * Each final consumer represents a specific user role page, combining the role selection
     * with the expected visibility of components for that role.
     * These consumers can be used in tests to verify that the DashboardPage behaves correctly
     * for different user roles.    
     */
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent).andThen(suComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> suPage = suSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentPresent);
}
