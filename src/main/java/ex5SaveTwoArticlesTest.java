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
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "cant find element",
//                5
//        );

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        String search_line = "Java";
        String name_of_folder = "Learning programming";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']") ,
//                "Cannot find search input",
//                5
//        );

        SearchPageObject.checkAndClickOnArticleDescription("Object-oriented programming language");

//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find search input",
//                5
//        );
        SearchPageObject.checkPageTitle();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
        SearchPageObject.checkAndClickOnMoreOptionsButton();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find option to add to reading list",
//                5
//        );
        SearchPageObject.checkElementIsPresentByXpath("Add to reading list");
        SearchPageObject.clickOnElementByXpathByText("Add to reading list");

//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find 'Got it' tip overlay",
//                5
//        );
        SearchPageObject.checkAndClickOnOnboardingButton();

//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot find text input",
//                5
//        );
        SearchPageObject.checkAndClearInputField();

//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "Cannot put text into articles folder input",
//                5
//        );
        SearchPageObject.typeFoldName(name_of_folder);

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='OK']"),
//                "Cannot find press OK button",
//                5
//        );
        SearchPageObject.clickOnElementByXpathByText("OK");

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot press X button",
//                5
//        );
        SearchPageObject.checkAndClickNavigateUpButton();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "cant find element",
//                5
//        );
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Island of Indonesia, Southeast Asia']") ,
//                "Cannot find search input",
//                5
//        );
        SearchPageObject.checkAndClickOnArticleDescription("Island of Indonesia, Southeast Asia");

//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find option to add to reading list",
//                5
//        );
        SearchPageObject.checkPageTitle();
        SearchPageObject.checkAndClickOnMoreOptionsButton();
        SearchPageObject.checkElementIsPresentByXpath("Add to reading list");
        SearchPageObject.clickOnElementByXpathByText("Add to reading list");

//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/item_title"),
//                "Cannot find added reading list",
//                5
//        );
        SearchPageObject.checkAndClickOnExistedFold();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot press X button",
//                5
//        );
        SearchPageObject.checkAndClickNavigateUpButton();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find 'My lists' button",
//                5
//        );
        SearchPageObject.checkAndClickMyListButton();

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find Learning programming text",
//                5
//        );
        SearchPageObject.checkAndClickOnFolderWithSavedArticles(name_of_folder);

//        MainPageObject.swipeElementToLeft(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot find saved article"
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot delete saved article",
//                5
//        );
        SearchPageObject.swipeToLeft("Java (programming language)");
        SearchPageObject.checkNameOfArticleNotPresent("Java (programming language)");

//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='island of Indonesia, Southeast Asia']"),
//                "Cannot delete saved article",
//                5
//        );

        String title_on_my_lists_screen = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/page_list_item_title"),
                "text",
                "Cannot find title of article on my lists screen",
                10
        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Java']"),
//                "Cannot find title 'Java' on 'My lists'",
//                5
//        );
        SearchPageObject.clickOnElementByXpathByText("Java");

        String title_after_click_on_article = SearchPageObject.getAttributeOfPageTitle();

        Assert.assertEquals(
                "Article title have been changed after open article",
                title_on_my_lists_screen,
                title_after_click_on_article
        );
    }
}