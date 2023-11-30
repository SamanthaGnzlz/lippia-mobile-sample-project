package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.HomeService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class HomeSteps extends PageSteps {

    @Then("Home page is displayed")
    public void isHomePageVisible() {
        HomeService.isViewLoaded();
    }

    @When("The user taps on + button")
    public void tapsPlusButton() {
        HomeService.tapPlusButton();
    }

    @When("The user taps on the three lines menu")
    public void theUserTapsOnTheThreeLinesMenu() {
        HomeService.tapHamburgerButton();
    }

    @io.cucumber.java.en.When("The user taps on settings button")
    public void theUserTapsOnSettingsButton() {
        HomeService.tapSettingsButton();
    }

    @io.cucumber.java.en.When("The user enable dark mode")
    public void theUserEnableDarkMode() {
        HomeService.enableDarkMode();
    }

    @io.cucumber.java.en.Then("Dark mode is enabled")
    public void darkModeIsEnabled() {
        HomeService.checkDarkMode();
    }
}
