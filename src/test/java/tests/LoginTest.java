package tests;

import org.testng.annotations.Test;
import website.HomePage;
import website.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test(priority = 1)
    public void enterValidLogintestCredentials() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPopUp();
        loginPage.loginToTravelSite("tvtestaccount@yopmail.com", "login123");

    }

    @Test(priority = 2)
    public void validateUserIsLoggedIn() {

        loginPage.validateUserLoggedInUrl();


    }
}
//******** this is for PAge factory generics Model if applied **********//
//        page.GetInstance(LoginPage.class).goToLoginPopUp();
//        page.GetInstance(LoginPage.class).loginToTravelSite("tvtestaccount@yopmail.com", "login123");
//        //this method below validates user is in correct page when user should be logged
//        page.GetInstance(LoginPage.class).validateUserLoggedInUrl();