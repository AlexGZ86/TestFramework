package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import website.HomePage;

public class HomepageTest extends TestBase {

    HomePage homePage;

    @Test
    public void getHomepageTitle() {
        homePage = new HomePage(driver);
        homePage.homeIcon.isDisplayed();
        driver.getTitle();
        String actualTitle = "Primary Care Medical Centers for Seniors | ChenMed";
        Assert.assertSame(driver.getTitle(), actualTitle);

//    actualTitle = "Chenmedical";
//    Assert.assertEquals(driver.getTitle(), actualTitle,"title does not match");
    }


}
