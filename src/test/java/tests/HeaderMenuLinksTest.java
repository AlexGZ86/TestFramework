package tests;

import website.HomePage;
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
