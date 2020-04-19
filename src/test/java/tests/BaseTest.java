package tests;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class BaseTest {
    public WebDriverWait wait;
    public WebDriver driver;
//    public PageGenerator page;

    @BeforeTest
    public void setupBrowserUrl() {
        // setup the chromedriver using WebDriverManager for demo purposes * environments not set.

        chromedriver().setup();
        firefoxdriver().setup();
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.get("https://www.travelocity.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 45, 1000);

    }

//    @BeforeTest
//
//    public void waitforpage() {
//         waitForPageLoaded();
//    }


    @AfterClass
    public void getLogs() {
        //     driver.manage().logs().getAvailableLogTypes();

        System.out.println("================== BROWSER LOGS =======================");

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("================== BROWSER LOGS =======================");

    }

//    ****This is for Pagefactory class if it is enabled otherwise we follow a POM Model on every page class.****
//    @BeforeMethod
//    public void methodLevelSetup() throws Exception {
//        //Instantiate the Page Class
//        page = new PageGenerator(driver);

//        wait = new WebDriverWait(driver, 30);

//    }


    @AfterTest
    public void terminateSession() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);

            WebDriverWait wait = new WebDriverWait(driver, 45);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");

        }
        Reporter.log("JavaScript completed loading", true);
    }
}
