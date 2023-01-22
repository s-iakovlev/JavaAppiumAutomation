package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ArticleTests extends CoreTestCase {

    //домашняя работа 2
    @Test
    public void testCompareTitlePlaceholder()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.assertElementHasTextByXpath
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Search Wikipedia",
                        "Actual text isn't expected"
                );
    }

    //домашняя работа 6
    @Test
    public void testCheckArticleTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String search_line = "Java";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Object-oriented programming language");
        ArticlePageObject.checkPageTitle();
    }
}
