import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
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
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String search_line = "Java";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Object-oriented programming language");
        ArticlePageObject.checkPageTitle();

    }
}