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

        String search_line = "Java";
        String first_avaliable_article = "Island of Indonesia, Southeast Asia";
        String second_avaliable_article = "High-level programming language";

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(first_avaliable_article);
        SearchPageObject.waitForSearchResult(second_avaliable_article);
        SearchPageObject.clickCanselSearch();

        SearchPageObject.checkElementIsNotPresentByXpath("Island of Indonesia, Southeast Asia");
        SearchPageObject.checkElementIsNotPresentByXpath("High-level programming language");
    }
}