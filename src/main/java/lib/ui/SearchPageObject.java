package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            MORE_OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            INPUT_FIELD = "org.wikipedia:id/text_input",
            EXISTED_FOLDER_WITH_ARTICLES = "org.wikipedia:id/item_title";


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
        assertEquals(
                error_message,
                expected_text,
                actual_text
        );
    }

    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    public void checkAndClickOnArticleDescription(String text) {
        this.waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='" + text + "']"), "Cannot find article " + text, 5);
        this.waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='" + text + "']"), "Cannot find and click search init element", 5);
    }

    public void checkAndClickOnMoreOptionsButton() {
        this.waitForElementPresent(By.xpath(MORE_OPTIONS_BUTTON), "Cannot find more options button", 5);
        this.waitForElementAndClick(By.xpath(MORE_OPTIONS_BUTTON), "Cannot click more options button", 5);
    }

    public void checkAndClearInputField() {
        this.waitForElementPresent(By.id(INPUT_FIELD), "Cannot find input field", 5);
        this.waitForElementAndClear(By.id(INPUT_FIELD), "Cannot click input field", 5);
    }

    public void checkAndClickOnExistedFold() {
        this.waitForElementPresent(By.id(EXISTED_FOLDER_WITH_ARTICLES), "Cannot find folder with articles", 5);
        this.waitForElementAndClick(By.id(EXISTED_FOLDER_WITH_ARTICLES), "Cannot click on folder with articles", 5);
    }

    public void checkAndClickOnFolderWithSavedArticles(String name_of_folder) {
        this.waitForElementPresent(By.xpath("//*[@text='" + name_of_folder + "']"), "Cannot find folder with articles", 5);
        this.waitForElementAndClick(By.xpath("//*[@text='" + name_of_folder + "']"), "Cannot click folder with articles", 5);
    }

    public void checkNameOfArticleNotPresent(String text) {
        this.waitForElementNotPresent(By.xpath("//*[@text='" + text + "']"), "Cannot find element " + text, 5);
    }

    public void checkElementIsPresentByXpath(String text) {
        this.waitForElementIsPresent(By.xpath("//*[@text='" + text + "']"), "Cannot find element " + text, 15);
    }

    public void checkElementIsNotPresentByXpath(String text) {
        this.waitForElementNotPresentByXpath(By.xpath("//android.widget.TextView[@text='" + text + "']"), "Cannot find element " + text, 15);
    }

    public void clickOnElementByXpathByText(String name_of_element) {
        this.waitForElementAndClick(By.xpath("//*[@text='" + name_of_element + "']"), "Cannot find element " + name_of_element, 10);
    }
}
