import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;

public class ex5SaveTwoArticlesTest extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();

        this.MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSaveFirstArticleToMyList()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);

        String search_line = "Java";
        String name_of_folder = "Learning programming";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Object-oriented programming language");
        ArticlePageObject.checkPageTitle();
        SearchPageObject.checkAndClickOnMoreOptionsButton();

        SearchPageObject.checkElementIsPresentByXpath("Add to reading list");
        SearchPageObject.clickOnElementByXpathByText("Add to reading list");

        NavigationUI.checkAndClickOnOnboardingButton();

        SearchPageObject.checkAndClearInputField();
        SearchPageObject.typeFoldName(name_of_folder);
        SearchPageObject.clickOnElementByXpathByText("OK");
        NavigationUI.checkAndClickNavigateUpButton();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Island of Indonesia, Southeast Asia");

        ArticlePageObject.checkPageTitle();
        SearchPageObject.checkAndClickOnMoreOptionsButton();
        SearchPageObject.checkElementIsPresentByXpath("Add to reading list");
        SearchPageObject.clickOnElementByXpathByText("Add to reading list");
        SearchPageObject.checkAndClickOnExistedFold();

        NavigationUI.checkAndClickNavigateUpButton();
        MyListsPageObject.checkAndClickMyListButton();
        SearchPageObject.checkAndClickOnFolderWithSavedArticles(name_of_folder);

        NavigationUI.swipeToLeft("Java (programming language)");
        SearchPageObject.checkNameOfArticleNotPresent("Java (programming language)");
        String title_on_my_lists_screen = ArticlePageObject.getAttributeOfPageListTitle();
        SearchPageObject.clickOnElementByXpathByText("Java");
        String title_after_click_on_article = ArticlePageObject.getAttributeOfPageTitle();

        Assert.assertEquals(
                "Article title have been changed after open article",
                title_on_my_lists_screen,
                title_after_click_on_article
        );
    }
}