package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{
    private static final String
            MY_LIST_BUTTON = "//android.widget.FrameLayout[@content-desc='My lists']";

    public MyListsPageObject(AppiumDriver driver )
    {
        super(driver);
    }

    public void checkAndClickMyListButton() {
        this.waitForElementPresent(By.xpath(MY_LIST_BUTTON), "Cannot find My List button", 5);
        this.waitForElementAndClick(By.xpath(MY_LIST_BUTTON), "Cannot click My List button", 5);
    }
}
