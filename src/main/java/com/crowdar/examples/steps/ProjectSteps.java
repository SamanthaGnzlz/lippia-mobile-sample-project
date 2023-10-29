package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.ProjectService;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;

public class ProjectSteps extends PageSteps {
    @When("The user choose Project 1")
    public void chooseProject() {
        ProjectService.chooseProject();
    }

    @And("project1 is displayed")
    public void isProjectDisplayed() {
        ProjectService.isProjectDisplayed();
    }
}
