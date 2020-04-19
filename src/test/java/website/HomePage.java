package website;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


/* Created by Alex Galindo //using Travelocity as an example to run test cases *******
 *   March 30th 2020
 * */

public class HomePage extends BasePage{

    @FindBy(css = "img[alt='PHPTRAVELS | Travel Technology Partner']")
    public WebElement homeIcon;

    @FindBy(css = "[title='home']")
    public WebElement homeMenu;


    public HomePage(WebDriver driver) {
        super(driver);

    }



//    public void clickHeaderMenus() {
//
//        try {
////
//            System.out.println("Page");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }





}
//**** use random selection to fill out fields in *****//

//    public void select_PersonalInfo_Title() {
//
//        int index = random.nextInt(4) + 2;  // Range between 0 to x + 2 because I don't want the 0 option nor the first
//        Select list = new Select(PersonalInfo_Title);
//        list.selectByIndex(index);
//
//    }
//
//    public void select_PersonalInfo_DOB_() throws Exception {
//
//        PersonalInfo_DOB.clear();
//        String date = getRandomBirthDate();
//        System.out.println(date);
//        PersonalInfo_DOB.sendKeys(date);
//        Thread.sleep(750);
//        clickEscapeButton();
//        waitForInvisibility(calendarWindow);
//    }
//
//    public void selectCountryOfBirth() {
//
//        int index = random.nextInt(100) + 1;
//        Select list = new Select(PersonalInfo_BirthNation);
//        list.selectByIndex(index);
//    }




