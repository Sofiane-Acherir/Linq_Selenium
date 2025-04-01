package test_home_page_logo;

import BasePage.Base;
import Pages.WelcomePage;
import Utils.TestIRetryAnalyzer.MyRetry;
import Utils.screenrecorder_screenshot.ScreenRecorderUtil;
import Utils.screenrecorder_screenshot.ScreenshotUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestHomePageLogo extends Base {
    WelcomePage welcomePage;


    @Test(priority = 1)
    public void testLogoHomepage() {


        welcomePage = new WelcomePage();
        Assert.assertTrue(isElementVisible(welcomePage.linqLogo));


    }

    // test with logs manually
    @Test(priority = 2)
    public void testHomepageTitle() {

        welcomePage = new WelcomePage();
        String actualTitle = driver.getTitle();

        String expectedTitle = "Linq App";

        Assert.assertEquals(actualTitle, expectedTitle);


    }

    // test with screenShoot and screenRecorder and retryAnalyzer
    @Test(priority = 3, retryAnalyzer = MyRetry.class, description = "Defect ID: BUG-5678 - Background color should be red but is incorrect")
    public void testBackGroundColor() throws Exception {
        // Start screen recording
        ScreenRecorderUtil.startRecord("testBackGroundColo");

        welcomePage = new WelcomePage();

        // Find the input field and type into it
        welcomePage.inputFieldPhoneNumber("About to blur");

        // Trigger blur event using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", welcomePage.backGroundColor);

        // Get the background color of the surrounding box (in RGB format)
        String rgbBackGroundColor = welcomePage.backGroundColor.getCssValue("background-color");
        System.out.println("This is the color in RGB format: " + rgbBackGroundColor);

        // Expected RGB value for red
        String expectedColor = "rgb(255, 0, 0)";

        // Verify background color
        Assert.assertEquals(rgbBackGroundColor, expectedColor,
                "BUG-5678: Background color should be red but is " + rgbBackGroundColor);

        // Take screenshot using ScreenshotUtil
        ScreenshotUtil.takeScreenshot(driver, "screenshotLogs");

        // End screen recording
        ScreenRecorderUtil.stopRecord();
    }


    @Test(priority = 4, description = "Defect ID: BUG-1234 - Invalid email is incorrectly accepted")
    public void testEmailFeature() throws Exception {
         //Start screen recording (uncomment if needed)
         ScreenRecorderUtil.startRecord("testEmailFeature");

        welcomePage = new WelcomePage();

        welcomePage.clickEmailButton();
        Assert.assertTrue(isElementVisible(welcomePage.signInWithEmailText));

        welcomePage.inputFieldEmailAddress("atb@gml.com");

        // Locate shadow DOM element via JavaScript
        String shadowDOMScript = "return document.querySelector('#main ion-content ion-button').shadowRoot.querySelector('button > span')";
        WebElement shadowElement = (WebElement) ((JavascriptExecutor) driver).executeScript(shadowDOMScript);

        // Scroll into view to ensure visibility
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shadowElement);

        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shadowElement));

        // Click the element via JavaScript to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shadowElement);


//        // test assertion
//        String script = "return document.querySelector('ion-title')";
//        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(script);
//
//        if (element == null) {
//            Assert.fail("'ion-title' element is not found in the DOM.");
//        }


         //Take screenshot using ScreenshotUtil
         ScreenshotUtil.takeScreenshot(driver, "screenshotLogs");

         //End screen recording
         ScreenRecorderUtil.stopRecord();
    }
}







