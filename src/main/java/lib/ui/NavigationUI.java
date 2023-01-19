package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
    private static final String
            ONBOARDING_BUTTON = "org.wikipedia:id/onboarding_button",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            NAVIGATE_UP_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void checkAndClickNavigateUpButton() {
        this.waitForElementPresent(By.xpath(NAVIGATE_UP_BUTTON), "Cannot find Navigate button", 5);
        this.waitForElementAndClick(By.xpath(NAVIGATE_UP_BUTTON), "Cannot click Navigate button", 5);
    }

    public void checkAndClickOnOnboardingButton() {
        this.waitForElementPresent(By.id(ONBOARDING_BUTTON), "Cannot find onboarding button", 5);
        this.waitForElementAndClick(By.id(ONBOARDING_BUTTON), "Cannot click onboarding button", 5);
    }

    public void clickCanselSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON),"Cannot find and click search cancel button ",5);
    }

    public void swipeToLeft(String text) {
        this.swipeElementToLeft(By.xpath("//*[@text='" + text + "']"), "Cannot swipe element " + text);
    }
}