package WebSite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage  {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
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

    BasePage basePage = PageFactory.initElements(driver, BasePage.class);

    public void gotoNews() {

        basePage.scrollToClick(NewsLink);
        NewsLink.click();
    }

    public void goToAboutUs() {
        basePage.scrollToClick(AboutUsLink);

    }

    public void gotoCareers() {

        CareersLink.click();
    }
    public void gotoExecutive() {

        ExectiveTeamLink.click();

    }
    public void gotoLocations() {

        locationLink.click();

    }
    public void gotoContactUs() {

        ContactUsLink.click();

    }
    public void gotoBlog() {

        Blog.click();

    }


}

