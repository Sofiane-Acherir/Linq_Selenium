package Utils.screenrecorder_screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final String DEFAULT_SCREENSHOT_DIR = System.getProperty("user.dir") + "\\test-output\\screenshots\\";

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        takeScreenshot(driver, screenshotName, DEFAULT_SCREENSHOT_DIR);
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName, String screenshotDir) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = screenshotName + "_" + timestamp + ".png";
            File destinationFile = new File(screenshotDir, fileName);

            if (!destinationFile.getParentFile().exists() && !destinationFile.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directories for screenshot storage.");
            }

            FileHandler.copy(screenshotFile, destinationFile);
            System.out.println("Screenshot saved as: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("IOException occurred while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Capture screenshot if the test is ignored
    public static void captureScreenshotOnIgnore(WebDriver driver, ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            String ignoredTestName = "IGNORED_" + result.getName();
            takeScreenshot(driver, ignoredTestName);
            System.out.println("Test ignored: " + result.getName() + " - Captured screenshot.");
        }
    }
}


