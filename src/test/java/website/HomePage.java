package website;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/* Created by Alex Galindo
 *   March 27th 2020
 * */

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this .driver = driver;
        PageFactory.initElements(driver, this );

    }

    @FindBy(id = "block-chenmed-branding")
    public WebElement homeIcon;

    @FindBy(css = "nav#block-chenmed-main-menu > ul > li:nth-of-type(1) > a")
    public WebElement AboutUsLink;

    @FindBy(css = "a[title='News']")
    public WebElement NewsLink;

    @FindBy(css = "nav#block-chenmed-main-menu > ul > li:nth-of-type(3) > a")
    public WebElement CareersLink;

    @FindBy(css = "nav#block-chenmed-main-menu > ul > li:nth-of-type(4) > a")
    public WebElement ExectiveTeamLink;

    @FindBy(css = "nav#block-chenmed-main-menu > ul > li:nth-of-type(5) > a")
    public WebElement locationLink;

    @FindBy(css = "nav#block-chenmed-main-menu > ul > li:nth-of-type(6) > a")
    public WebElement ContactUsLink;

    @FindBy(css = "nav#block-chenmed-main-menu a[title='Blog']")
    public WebElement Blog;


//    BasePage basePage = new BasePage(driver);

    public void gotoNews() {

        try {
            NewsLink.click();
            System.out.println("Page clicked on and Displayed is : " + NewsLink.getText());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void goToAboutUs() {
//        basePage.scrollToClick(AboutUsLink);
        try {
            AboutUsLink.click();
            System.out.println("Page clicked on and Displayed is : " + AboutUsLink.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoCareers() {
//        basePage.scrollToClick(CareersLink);

        try {
            CareersLink.click();
            System.out.println("Page clicked on and Displayed is : " + CareersLink.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void gotoExecutive() {

        try {
            ExectiveTeamLink.click();
            System.out.println("Page clicked on and Displayed is : " + CareersLink.getText());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void gotoLocations() {

        try {
            locationLink.click();
            System.out.println("Page clicked on and Displayed is : " + locationLink.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void gotoContactUs() {

        try {
            ContactUsLink.click();
            System.out.println("Page clicked on and Displayed is : " + ContactUsLink.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void gotoBlog() {
        try {
            Blog.click();
            System.out.println("Page clicked on and Displayed is : " + Blog.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


