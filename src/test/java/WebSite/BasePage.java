package WebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  public WebDriver driver;

  public WebDriverWait wait ;//= new WebDriverWait(driver, 60);

  public BasePage(WebDriver driver) {
    this.driver=driver;
  }

  public <T> void waitForVisible_Click(T element) {
    if (element.getClass().getName().contains("By")) {
      wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
      driver.findElement((By) element).click();

    } else {
      System.out.println("Could not find visible element ");
    }
  }

  protected <T> void writeText(T element, String text) {
    if (element.getClass().getName().contains("By")) {
      driver.findElement((By) element).sendKeys(text);
    } else {
      ((WebElement) element).sendKeys(text);
    }
  }

  public <T> void scrollToClick(T element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
  }

  public <T> String readText(T element) {
    if (element.getClass().getName().contains("By")) {
      return driver.findElement((By) element).getText();

    } else {
      return ((WebElement) element).getText();
    }
  }
}
