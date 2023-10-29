package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.constants.ProjectConstants;
import org.testng.Assert;

public class ProjectService {
    public static void chooseProject() {
        MobileActionManager.click(HomeConstants.PROJECTS_LOCATOR);
        MobileActionManager.waitVisibility(ProjectConstants.PROJECT1_LOCATOR);
        MobileActionManager.click(ProjectConstants.PROJECT1_LOCATOR);

    }

    public static void isProjectDisplayed() {
        String projectName = MobileActionManager.getText(HomeConstants.PROJECT_NAME_LOCATOR);
        Assert.assertEquals(projectName, "project1", HomeConstants.PROJECT_NAME_NOT_DISPLAYED_MESSAGE);
    }
}
