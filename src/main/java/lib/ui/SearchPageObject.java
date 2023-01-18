package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            OBJECT_ORIENTED_PROGRAMMING_LANGUAGE = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']",
            ISLAND_OF_INDONESIA_ARTICLE = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Island of Indonesia, Southeast Asia']",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            PAGE_TITLE = "org.wikipedia:id/view_page_title_text",
            MORE_OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            ONBOARDING_BUTTON = "org.wikipedia:id/onboarding_button",
            INPUT_FIELD = "org.wikipedia:id/text_input",
            NAVIGATE_UP_BUTTON ="//android.widget.ImageButton[@content-desc='Navigate up']",
            EXISTED_FOLDER_WITH_ARTICLES = "org.wikipedia:id/item_title",
            MY_LIST_BUTTON = "//android.widget.FrameLayout[@content-desc='My lists']";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /*template methods*/
    /*template methods*/

    public void initSearchInput() {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT),search_line,"Cannot find and type into search input",5);
    }

    public void typeFoldName(String name_of_folder)
    {
        this.waitForElementAndSendKeys(By.id(INPUT_FIELD),name_of_folder,"Cannot find and type into fold name input field",5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring, 5);
    }

    public void assertElementHasTextByXpath(By xpath, String expected_text, String error_message)
    {
        String actual_text = driver.findElement(xpath).getText();
        Assert.assertEquals(
                error_message,
                expected_text,
                actual_text
        );
    }

    public void clickCanselSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON),"Cannot find and click search cancel button ",5);
    }

    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    public void checkAndClickOnArticleDescription(String text) {
        this.waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='" + text + "']"), "Cannot find article " + text, 5);
        this.waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='" + text + "']"), "Cannot find and click search init element", 5);
    }

    public void checkPageTitle() {
        this.waitForElementPresent(By.id(PAGE_TITLE), "Cannot find page title", 5);
    }

    public void checkAndClickOnMoreOptionsButton() {
        this.waitForElementPresent(By.xpath(MORE_OPTIONS_BUTTON), "Cannot find more options button", 5);
        this.waitForElementAndClick(By.xpath(MORE_OPTIONS_BUTTON), "Cannot click more options button", 5);
    }

    public void checkAndClickOnOnboardingButton() {
        this.waitForElementPresent(By.id(ONBOARDING_BUTTON), "Cannot find onboarding button", 5);
        this.waitForElementAndClick(By.id(ONBOARDING_BUTTON), "Cannot click onboarding button", 5);
    }

    public void checkAndClearInputField() {
        this.waitForElementPresent(By.id(INPUT_FIELD), "Cannot find input field", 5);
        this.waitForElementAndClear(By.id(INPUT_FIELD), "Cannot click input field", 5);
    }

    public void checkAndClickNavigateUpButton() {
        this.waitForElementPresent(By.xpath(NAVIGATE_UP_BUTTON), "Cannot find Navigate button", 5);
        this.waitForElementAndClick(By.xpath(NAVIGATE_UP_BUTTON), "Cannot click Navigate button", 5);
    }

    public void checkAndClickOnExistedFold() {
        this.waitForElementPresent(By.id(EXISTED_FOLDER_WITH_ARTICLES), "Cannot find folder with articles", 5);
        this.waitForElementAndClick(By.id(EXISTED_FOLDER_WITH_ARTICLES), "Cannot click on folder with articles", 5);
    }

    public void checkAndClickMyListButton() {
        this.waitForElementPresent(By.xpath(MY_LIST_BUTTON), "Cannot find My List button", 5);
        this.waitForElementAndClick(By.xpath(MY_LIST_BUTTON), "Cannot click My List button", 5);
    }

    public void checkAndClickOnFolderWithSavedArticles(String name_of_folder) {
        this.waitForElementPresent(By.xpath("//*[@text='" + name_of_folder + "']"), "Cannot find folder with articles", 5);
        this.waitForElementAndClick(By.xpath("//*[@text='" + name_of_folder + "']"), "Cannot click folder with articles", 5);
    }

    public void swipeToLeft(String text) {
        this.swipeElementToLeft(By.xpath("//*[@text='" + text + "']"), "Cannot swipe element " + text);
    }

    public void checkNameOfArticleNotPresent(String text) {
        this.waitForElementNotPresent(By.xpath("//*[@text='" + text + "']"), "Cannot find element " + text, 5);
    }

    public void checkElementIsPresentByXpath(String text) {
        this.waitForElementNotPresent(By.xpath("//*[@text='" + text + "']"), "Cannot find element " + text, 15);
    }

    public void clickOnElementByXpathByText(String name_of_element) {
        this.waitForElementAndClick(By.xpath("//*[@text='" + name_of_element + "']"), "Cannot find element " + name_of_element, 10);
    }

    public String getAttributeOfPageTitle() {
        return this.waitForElementAndGetAttribute
                (
                        By.id(PAGE_TITLE),
                        "text",
                        "Cannot find title of article on article page",
                        5
                );
    }
}
