package BasePage;

import Utils.driver_event_listener.DriverEventListener;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Arrays;


public class Base {
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public static FirefoxOptions firefoxOptions;
    public static EdgeOptions edgeOptions;
    public static WebDriverWait webDriverWait;
    public static Wait<WebDriver> fluentWait;

    @Parameters({"driverConfigEnabled", "browser", "url"})
    @BeforeMethod
    public void driverSetup(@Optional("true") String driverConfigEnabled, @Optional("chrome") String browser, @Optional("https://staging-web.linqapp.com/welcome") String url) {
        if (Boolean.parseBoolean(driverConfigEnabled)) {
            driverInit(browser);
            driver.get(url);
            driver.manage().deleteAllCookies();
        }
    }

    @Parameters({"driverConfigEnabled"})
    @AfterMethod
    public void cleanUp(@Optional("true") String driverConfigEnabled) {
        if (Boolean.parseBoolean(driverConfigEnabled)) {
            driver.quit();
        }
    }

    private static void driverInit(String browser) {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infoBars"));

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        edgeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infoBars"));

        WebDriver baseDriver;
        if (browser.equalsIgnoreCase("chrome")) {
            baseDriver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            baseDriver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equalsIgnoreCase("edge")) {
            baseDriver = new EdgeDriver(edgeOptions);
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        // Wrap driver with EventFiringDecorator and DriverEventListener
        driver = new EventFiringDecorator<>(new DriverEventListener()).decorate(baseDriver);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

    }

    // Methods
    public void sendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void clickOnElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean validationURL(WebDriver driver, String expURL) {
        return driver.getCurrentUrl().equalsIgnoreCase(expURL);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
