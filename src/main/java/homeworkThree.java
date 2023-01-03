import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class homeworkThree {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", " ");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", " ");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testCompareTitlePlaceholder(){
        waitForElementPresent(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can't find element",
                5
        );

        assertElementHasTextByXpath(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search Wikipedia",
                "Actual text isn't expected"
        );
    }

    @Test
    public void CancelSearchTest(){
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Can't find element",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Can't find element",
                5
        );

        waitForElementIsPresent(
                By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
                "Actual text isn't expected",
                5
        );

        waitForElementIsPresent(
                By.xpath("//android.widget.TextView[@text='High-level programming language']"),
                "Actual text isn't expected",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Can't find search field",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Can't find close button",
                5
        );

        waitForElementNotPresentById(
                By.id("org.wikipedia:id/search_close_btn"),
                "Can't find close button",
                5
        );

        waitForElementNotPresentByXpath(
                By.xpath("//android.widget.TextView[@text='Island of Indonesia, Southeast Asia']"),
                "Element of search is on the page",
                5
        );

        waitForElementNotPresentByXpath(
                By.xpath("//android.widget.TextView[@text='High-level programming language']"),
                "Element of search is on the page",
                5
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private void assertElementHasTextByXpath(By xpath, String expected_text, String error_message)
    {
        String actual_text = driver.findElement(xpath).getText();
        Assert.assertEquals(
                error_message,
                expected_text,
                actual_text
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresentById(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private boolean waitForElementNotPresentByXpath(By xpath, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(xpath)
        );
    }

    private WebElement waitForElementIsPresent(By xpath, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(xpath)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
}