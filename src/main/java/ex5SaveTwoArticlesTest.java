import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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

        String search_line = "Java";
        String name_of_folder = "Learning programming";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Object-oriented programming language");
        SearchPageObject.checkPageTitle();
        SearchPageObject.checkAndClickOnMoreOptionsButton();

        SearchPageObject.checkElementIsPresentByXpath("Add to reading list");
        SearchPageObject.clickOnElementByXpathByText("Add to reading list");

        SearchPageObject.checkAndClickOnOnboardingButton();

        SearchPageObject.checkAndClearInputField();
        SearchPageObject.typeFoldName(name_of_folder);
        SearchPageObject.clickOnElementByXpathByText("OK");
        SearchPageObject.checkAndClickNavigateUpButton();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.checkAndClickOnArticleDescription("Island of Indonesia, Southeast Asia");

        SearchPageObject.checkPageTitle();
        SearchPageObject.checkAndClickOnMoreOptionsButton();
        SearchPageObject.checkElementIsPresentByXpath("Add to reading list");
        SearchPageObject.clickOnElementByXpathByText("Add to reading list");
        SearchPageObject.checkAndClickOnExistedFold();

        SearchPageObject.checkAndClickNavigateUpButton();
        SearchPageObject.checkAndClickMyListButton();
        SearchPageObject.checkAndClickOnFolderWithSavedArticles(name_of_folder);

        SearchPageObject.swipeToLeft("Java (programming language)");
        SearchPageObject.checkNameOfArticleNotPresent("Java (programming language)");
        String title_on_my_lists_screen = SearchPageObject.getAttributeOfPagelISTTitle();
        SearchPageObject.clickOnElementByXpathByText("Java");
        String title_after_click_on_article = SearchPageObject.getAttributeOfPageTitle();

        Assert.assertEquals(
                "Article title have been changed after open article",
                title_on_my_lists_screen,
                title_after_click_on_article
        );
    }
}