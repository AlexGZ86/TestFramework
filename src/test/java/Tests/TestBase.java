package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class TestBase {
  public WebDriverWait wait;
  public WebDriver driver;


  @BeforeSuite
  public void setupClass() {
    // setup the chromedriver using WebDriverManager
    chromedriver().setup();


    driver = new ChromeDriver();
    driver.get("https://www.chenmed.com/");
    driver.manage().window().maximize();
    waitForPageLoaded();

    wait = new WebDriverWait(driver, 30, 1000);
  }
  @BeforeTest
  public void waitforpage(){
    waitForPageLoaded();
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
    Reporter.log("waited for page JS to load", true);
  }
}
