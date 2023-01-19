package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject{

    private static final String
            PAGE_TITLE = "org.wikipedia:id/view_page_title_text",
            PAGE_LIST_TITLE = "org.wikipedia:id/page_list_item_title";

    public ArticlePageObject(AppiumDriver driver )
    {
        super(driver);
    }

    public void checkPageTitle() {
        this.waitForElementPresent(By.id(PAGE_TITLE), "Cannot find page title", 5);
    }

    public String getAttributeOfPageTitle() {
        return this.waitForElementAndGetAttribute
                (
                        By.id(PAGE_TITLE),
                        "text",
                        "Cannot find title of article on article page",
                        5
                );
    }

    public String getAttributeOfPageListTitle() {
        return this.waitForElementAndGetAttribute
                (
                        By.id(PAGE_LIST_TITLE),
                        "text",
                        "Cannot find title of article on article page",
                        5
                );
    }
}
