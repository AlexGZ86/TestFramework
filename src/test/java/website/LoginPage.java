package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {

        super(driver);
    }
    //*********Web Elements by using Page Factory*********

    @FindBy(css = "button#header-account-menu")
    public WebElement Account;
    @FindBy(css = "a#account-signin")
    public WebElement signInButton;


    public void goToLoginPopUp() {
        scrollToElement(Account);
        scrollToElement(signInButton);
        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements

    }

    //*********Web Elements*********
    @FindBy(how = How.CSS, using = "input#gss-signin-email")
    public WebElement username;
    @FindBy(how = How.CSS, using = "input#gss-signin-password")
    public WebElement password;
    @FindBy(how = How.CSS, using = "button#gss-signin-submit")
    public WebElement loginButton;
    @FindBy(how = How.ID, using = "gss-keep-signin-check")
    public WebElement keepUserSgnedInCheck;




    //*********Page Methods*********

    public void loginToTravelSite(String pusername, String ppassword) throws Exception {

        //always call your page to enable functions from PAGES*****?
        writeText(username, pusername);
        //Enter Password
        writeText(password, ppassword);

        // keep user signed in by deafault//
        if (!keepUserSgnedInCheck.isSelected()) {
            keepUserSgnedInCheck.click();
            System.out.println("keep me logged in is selected by default");
        }

        //Click Login Button
        scrollToElement(loginButton);
    }

//iframe name : c-jdngg7q3n4os
    //title : recaptcha challenge
    //id:


    @FindBy(how = How.XPATH, using = "//button[@id='header-account-menu-signed-in']//span[@id='userGreetingName']")
    public boolean AccountLoggedIn;

    public void validateUserLoggedInUrl() {
        if (driver.findElements(By.id("rc-imageselect")).size() != 0) {

            driver.switchTo().frame("rc-imageselect");
            System.out.println("UNABLE TO COMPLETE AUTOMATED LOGIN DUE TO CAPTCHA DETECTED!!");

        } else {
        Assert.assertTrue(AccountLoggedIn);

        }
    }
}



