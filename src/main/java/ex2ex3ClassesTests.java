import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ex2ex3ClassesTests extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();

        this.MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCompareTitlePlaceholder()
    {
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can't find element",
//                5
//        );
//
//        MainPageObject.assertElementHasTextByXpath(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Search Wikipedia",
//                "Actual text isn't expected"
//        );

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.assertElementHasTextByXpath
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Search Wikipedia",
                        "Actual text isn't expected"
                );
    }

    @Test
    public void testCancelSearch(){

//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_container"),
//                "Can't find element",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Can't find element",
//                5
//        );
//
//        MainPageObject.waitForElementIsPresent(
//                By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
//                "Actual text isn't expected",
//                5
//        );
//
//        MainPageObject.waitForElementIsPresent(
//                By.xpath("//android.widget.TextView[@text='High-level programming language']"),
//                "Actual text isn't expected",
//                5
//        );
//
//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Can't find search field",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Can't find close button",
//                5
//        );
//
//        MainPageObject.waitForElementNotPresentById(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Can't find close button",
//                5
//        );
//
//        MainPageObject.waitForElementNotPresentByXpath(
//                By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
//                "Element of search is on the page",
//                5
//        );
//
//        MainPageObject.waitForElementNotPresentByXpath(
//                By.xpath("//android.widget.TextView[@text='High-level programming language']"),
//                "Element of search is on the page",
//                5
//        );

        String search_line = "Java";
        String first_avaliable_article = "Island of Indonesia, Southeast Asia";
        String second_avaliable_article = "High-level programming language";

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(first_avaliable_article);
        SearchPageObject.waitForSearchResult(second_avaliable_article);
        SearchPageObject.clickCanselSearch();

        MainPageObject.waitForElementNotPresentByXpath
                (
                        By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
                "Element of search is on the page",
                5
                );
        MainPageObject.waitForElementNotPresentByXpath
                (
                        By.xpath("//android.widget.TextView[@text='High-level programming language']"),
                        "Element of search is on the page",
                        5
                );
    }
}