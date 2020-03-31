package WebSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageConstructor {

  public WebDriver driver;

  // Constructor
  public PageConstructor(WebDriver driver) {
    this.driver = driver;


    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
  }
}