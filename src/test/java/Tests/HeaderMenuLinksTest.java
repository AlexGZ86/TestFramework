package Tests;

import WebSite.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HeaderMenuLinksTest extends TestBase{



    HomePage homePage = PageFactory.initElements(driver,HomePage.class);

    @Test
    public void clickAboutUs(){
        homePage.goToAboutUs();
    }

    @Test
    public void clickNews(){
    homePage.gotoNews();
    }

    @Test
    public void clickCareers(){
    homePage.gotoCareers();
    }

    @Test
    public void clickExecutiveTeam(){
    homePage.gotoExecutive();
    }

    @Test
    public void clickLocations(){
    homePage.gotoLocations();
    }

    @Test
    public void clickContactUs(){
    homePage.gotoContactUs();
    }

    @Test
    public void clickBlog(){
    homePage.gotoBlog();
}

}
