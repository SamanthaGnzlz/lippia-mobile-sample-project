package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddEntryConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class AddEntryService {
    public static void setHours(String hour, String minute) {
        setTime(hour, AddEntryConstants.HOURS_LOCATOR, AddEntryConstants.LOWER_BUTTON_HOURS_LOCATOR);
        setTime(minute, AddEntryConstants.MINUTES_LOCATOR, AddEntryConstants.LOWER_BUTTON_MINUTES_LOCATOR );
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
        MobileActionManager.click(AddEntryConstants.SAVE_BUTTON_LOCATOR);
    }

    public static void isCardDisplayed() {
        MobileActionManager.waitVisibility(AddEntryConstants.CARD_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(AddEntryConstants.CARD_LOCATOR), AddEntryConstants.CARD_NOT_DISPLAYED_MESSAGE);
    }

    public static void tapStartHours() {
        MobileActionManager.waitVisibility(AddEntryConstants.START_HOURS_BUTTON_LOCATOR);
        MobileActionManager.click(AddEntryConstants.START_HOURS_BUTTON_LOCATOR);
    }

    public static void setStartHours(String hour, String minute) {
        setTime(minute, AddEntryConstants.SPECIFIC_MINUTES_LOCATOR, AddEntryConstants.SPECIFIC_LOWER_BUTTON_MINUTES_LOCATOR);
        setTime(hour, AddEntryConstants.SPECIFIC_HOURS_LOCATOR, AddEntryConstants.SPECIFIC_LOWER_BUTTON_HOURS_LOCATOR);
    }

    public static void setEndHours(String hour, String minute) {
        MobileActionManager.click(AddEntryConstants.END_BUTTON_LOCATOR);
        setTime(minute, AddEntryConstants.SPECIFIC_MINUTES_LOCATOR, AddEntryConstants.SPECIFIC_LOWER_BUTTON_MINUTES_LOCATOR);
        setTime(hour, AddEntryConstants.SPECIFIC_HOURS_LOCATOR, AddEntryConstants.SPECIFIC_LOWER_BUTTON_HOURS_LOCATOR);
    }

    public static void tapDate() {
        MobileActionManager.click(AddEntryConstants.DATE_LOCATOR);
    }

    public static void tapSpecificDate() {
        MobileActionManager.click(AddEntryConstants.NOVEMBER27TH_LOCATOR);
    }

    public static void tapGoBackButton() {
        MobileActionManager.click(AddEntryConstants.GO_BACK_BUTTON_LOCATOR);
    }

    public static void tapDiscardButton() {
        MobileActionManager.click(AddEntryConstants.DISCARD_BUTTON_LOCATOR);
    }

    public static void isCardDisplayedOnSpecificDay() {
        MobileActionManager.waitVisibility(AddEntryConstants.CARD_LOCATOR);
        WebElement element = MobileActionManager.getElement(AddEntryConstants.DATE_HOME_LOCATOR);
        Assert.assertEquals(element.getText(), "Mon, 27 Nov");
    }
}
