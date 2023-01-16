import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ex2ex3ClassesTests extends CoreTestCase {

    private lib.ui.MainPageObject MainPageObject;
    protected void SetUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCompareTitlePlaceholder()
    {
        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can't find element",
                5
        );

        MainPageObject.assertElementHasTextByXpath(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search Wikipedia",
                "Actual text isn't expected"
        );
    }

    @Test
    public void testCancelSearch(){

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Can't find element",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Can't find element",
                5
        );

        MainPageObject.waitForElementIsPresent(
                By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
                "Actual text isn't expected",
                5
        );

        MainPageObject.waitForElementIsPresent(
                By.xpath("//android.widget.TextView[@text='High-level programming language']"),
                "Actual text isn't expected",
                5
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Can't find search field",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Can't find close button",
                5
        );

        MainPageObject.waitForElementNotPresentById(
                By.id("org.wikipedia:id/search_close_btn"),
                "Can't find close button",
                5
        );

        MainPageObject.waitForElementNotPresentByXpath(
                By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
                "Element of search is on the page",
                5
        );

        MainPageObject.waitForElementNotPresentByXpath(
                By.xpath("//android.widget.TextView[@text='High-level programming language']"),
                "Element of search is on the page",
                5
        );
    }
}