package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class HomeService {


    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(HomeConstants.PLUS_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.PLUS_BUTTON_LOCATOR), HomeConstants.VIEW_NOT_DISPLAYED_MESSAGE);

    }

    public static void tapPlusButton() {
        MobileActionManager.click(HomeConstants.PLUS_BUTTON_LOCATOR);

    }


    public static void tapHamburgerButton() {
        MobileActionManager.click(HomeConstants.HAMBURGER_MENU_LOCATOR);
    }

    public static void tapSettingsButton() {
        MobileActionManager.waitVisibility(HomeConstants.SETTINGS_LOCATOR);
        MobileActionManager.click(HomeConstants.SETTINGS_LOCATOR);
    }

    public static void enableDarkMode() {
        MobileActionManager.click(HomeConstants.DARK_BUTTON_LOCATOR);
    }

    public static void checkDarkMode() {
        WebElement element = MobileActionManager.getElement(HomeConstants.DARK_BUTTON_LOCATOR);
        Assert.assertEquals(element.getAttribute("checked"), "true", "La opcion Enable dark mode no esta seleccionada");
    }
}
