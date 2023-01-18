import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ex6AssertTitle extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();

        this.MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCheckArticleTitle()
    {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search input",
//                5
//        );
//
//        String search_line = "Java";
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                search_line,
//                "cant find element",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Java']"),
//                "Cannot find 'Java' topic searching by" + search_line,
//                15
//        );
//
//        MainPageObject.assertElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find title of article"
//        );

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        String search_line = "Java";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Object-oriented programming language");
        SearchPageObject.checkPageTitle();

    }
}