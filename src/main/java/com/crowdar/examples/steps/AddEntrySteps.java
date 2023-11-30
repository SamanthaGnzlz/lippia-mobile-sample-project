package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.AddEntryService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEntrySteps extends PageSteps {
    @When("The user sets the hours to (.*):(.*)hs")
    public void setHours(String hour, String minute) {
        AddEntryService.setHours(hour, minute);
    }

    @When("The user taps on save button")
    public void tapsSaveButton() {
        AddEntryService.tapSaveButton();
    }

    @Then("a card is displayed with the hours logged")
    public void isCardDisplayed() {
        AddEntryService.isCardDisplayed();
    }

    @When("The user taps on star hours")
    public void theUserTapsOnStarHours() {
        AddEntryService.tapStartHours();
    }

    @When("The user set start hours to (.*):(.*)hs")
    public void theUserSetStartHoursToHs(String hour, String minute) {
        AddEntryService.setStartHours(hour, minute);
    }

    @When("The user set end hours to (.*):(.*)hs")
    public void theUserSetEndHoursToHs(String hour, String minute) {
        AddEntryService.setEndHours(hour, minute);
    }

    @When("The user taps on today's date")
    public void theUserTapsOnTodaySDate() {
        AddEntryService.tapDate();
    }

    @When("The user taps on November 27th")
    public void theUserTapsOnNovemberTh() {
        AddEntryService.tapSpecificDate();
    }

    @When("The user taps on Go back button")
    public void theUserTapsOnGoBackButton() {
        AddEntryService.tapGoBackButton();
    }

    @When("The user taps on Discard button")
    public void theUserTapsOnDiscardButton() {
        AddEntryService.tapDiscardButton();
    }

    @io.cucumber.java.en.Then("a card is displayed with the hours logged on specific day")
    public void aCardIsDisplayedWithTheHoursLoggedOnSpecificDay() {
        AddEntryService.isCardDisplayedOnSpecificDay();
    }
}
