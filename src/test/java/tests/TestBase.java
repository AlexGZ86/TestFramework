package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class TestBase {
    public WebDriverWait wait;
    public WebDriver driver;


    @BeforeSuite
    public void setupClass() {
        // setup the chromedriver using WebDriverManager
        chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.chenmed.com/");



        wait = new WebDriverWait(driver, 30, 1000);
    }

    @BeforeTest
    public void waitforpage() {
        waitForPageLoaded();
    }



    @AfterClass
    public void getLogs() {
//        driver.manage().logs().getAvailableLogTypes();

        System.out.println("================== BROWSER LOGS =======================");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("================== BROWSER LOGS =======================");

    }



    @AfterSuite
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
        Reporter.log("waited for page JavaScript to complete loading", true);
    }
}
