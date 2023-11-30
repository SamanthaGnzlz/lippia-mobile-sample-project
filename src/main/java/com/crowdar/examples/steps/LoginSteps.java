package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.java.en.Then;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class LoginSteps extends PageSteps {

    @Given("The app is loaded correctly")
    public void isLoginPageVisible() {
        LoginService.isViewLoaded();
    }

    @Given("The user is logged in")
    @When("The user logs in the application with email and password")
    public void doLoginProcess() {
        LoginService.doLogin(PropertyManager.getProperty("email"), PropertyManager.getProperty("password"));
    }

    @When("The user taps on Log Out button")
    public void theUserTapsOnLogOutButton() {
        LoginService.doLogOut();
    }

    @Then("The user logs out")
    public void theUserLogsOut() {
        LoginService.isViewLoaded();
    }
}
