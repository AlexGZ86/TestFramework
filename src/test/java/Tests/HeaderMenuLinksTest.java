package Tests;

import WebSite.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderMenuLinksTest extends TestBase {
    HomePage homePage;

    @Test
    public void openHeaderLinks() {

        homePage = new HomePage(driver);

        homePage.goToAboutUs();

        homePage.gotoBlog();
        homePage.gotoCareers();
        homePage.gotoContactUs();
        homePage.gotoExecutive();
        homePage.gotoLocations();
        homePage.gotoNews();
    }
}
