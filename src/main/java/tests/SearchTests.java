package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    //домашнее задание 3
    @Test
    public void testCancelSearch(){

        String search_line = "Java";
        String first_avaliable_article = "Island of Indonesia, Southeast Asia";
        String second_avaliable_article = "High-level programming language";

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(first_avaliable_article);
        SearchPageObject.waitForSearchResult(second_avaliable_article);
        NavigationUI.clickCanselSearch();

        SearchPageObject.checkElementIsNotPresentByXpath("Island of Indonesia, Southeast Asia");
        SearchPageObject.checkElementIsNotPresentByXpath("High-level programming language");
    }

    //домашнее задание 5
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

        assertEquals(
                "Article title have been changed after open article",
                title_on_my_lists_screen,
                title_after_click_on_article
        );
    }
}
