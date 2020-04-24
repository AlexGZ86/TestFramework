package website;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Children extends BasePage {

    public Children(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//select[@id='flight-age-select-1-hp-flight']")
    public WebElement Children1AgeDropDown;

    @FindBy(xpath = "//select[@id='flight-age-select-2-hp-flight']")
    public WebElement Children2AgeDropDown;

    @FindBy(xpath = "//select[@id='flight-age-select-3-hp-flight']")
    public WebElement Children3AgeDropDown;

    @FindBy(css = "select#flight-children-hp-flight")
    public WebElement ChildrenCountDropDown;


    public void selectNoOfChildren() {
        //#of kids
        int Childrenindex = random.nextInt(3) + 1;  // Range between 0 to x + 1 because I don't want the 0 option nor the first
        Select kids = new Select(ChildrenCountDropDown);
        kids.selectByIndex(Childrenindex);
        System.out.println("selected random value between 1 and 4 for Children :" + Childrenindex);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");


        if (Childrenindex == 3) {
            selectKid1();
            selectKid2();
            selectKid3();
        }if (Childrenindex == 2){
            selectKid2();
            selectKid1();
        }if (Childrenindex == 1){
            selectKid1();
        }else {
            System.out.println("No children were selected for this trip search");
        }



    }
    public void selectKid1() {
        scrollToElement(Children1AgeDropDown);
        int index = random.nextInt(17) + 1;
        Select list = new Select(Children1AgeDropDown);
        list.selectByIndex(index);
        System.out.println("selected random value for Kids1 age, between 1 and 17 for Children :" + index);
    }

    public void selectKid2(){
        //waitForClickable(Children2AgeDropDown);
        int index2 = random.nextInt(17) + 1;
        Select list2 = new Select(Children2AgeDropDown);
        list2.selectByIndex(index2);
        System.out.println("selected random value for Kid #2 age, between 1 and 17 for Children :" + index2);
    }
    public void selectKid3(){
        int index3 = random.nextInt(17) + 1;
        Select list3 = new Select(Children3AgeDropDown);
        list3.selectByIndex(index3);
        System.out.println("selected random value for Kid #3 age, between 1 and 17 for Children :" + index3);

    }
}

