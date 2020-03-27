package Tests;

import WebSite.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class HomepageTest extends TestBase {

  @Test
  public void getHomepageTitle() {
    String actualTitle = "Primary Care Medical Centers for Seniors | ChenMed";
    Assert.assertEquals(driver.getTitle(), actualTitle);

    actualTitle = "Chenmedical";
    Assert.assertEquals(driver.getTitle(), actualTitle,"title does not match");
  }
}
