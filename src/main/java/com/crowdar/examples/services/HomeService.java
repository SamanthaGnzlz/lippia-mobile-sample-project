package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
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

    public static void setHours(String hour, String minute) {
        setTime(hour, HomeConstants.HOURS_LOCATOR, HomeConstants.LOWER_BUTTON_HOURS_LOCATOR);
        setTime(minute, HomeConstants.MINUTES_LOCATOR, HomeConstants.LOWER_BUTTON_MINUTES_LOCATOR );
    }

    private static void setTime(String time, String currentValueLocator, String lowerButtonLocator) {
        while (true) {
            String hourCurrentValue = MobileActionManager.getText(currentValueLocator);
            if (hourCurrentValue.equals(time)){
                break;
            }
            MobileActionManager.click(lowerButtonLocator);
        }
    }

    public static void tapSaveButton() {
        MobileActionManager.click(HomeConstants.SAVE_BUTTON_LOCATOR);
    }

    public static void isCardDisplayed() {
        MobileActionManager.waitVisibility(HomeConstants.CARD_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.CARD_LOCATOR), HomeConstants.CARD_NOT_DISPLAYED_MESSAGE);
    }


}
