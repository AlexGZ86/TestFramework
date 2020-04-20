package website;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.RandomStringGenerator;

import javax.swing.*;


public class Flights extends BasePage {

    public Flights(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = "button#tab-flight-tab-hp > .icon.icon-flights")
    public WebElement FlightTab;
    @FindBy(css = "label#flight-type-roundtrip-label-hp-flight")
    public WebElement RoundTrip;
    @FindBy(css = "label#flight-type-one-way-label-hp-flight")
    public WebElement OneWayTrip;
    @FindBy(css = "label#flight-type-multi-dest-label-hp-flight")
    public WebElement MultiCityDest;
    @FindBy(css = "input#flight-origin-hp-flight")
    public WebElement FlyingFromFieldCityOrAirport;
    @FindBy(css = "input#flight-destination-hp-flight")
    public WebElement FlyingToFieldCityOrAirport;
    @FindBy(css = "input#flight-departing-hp-flight")
    public WebElement DepartingDates;
    @FindBy(xpath = "//div[@id='flight-returning-wrapper-hp-flight']//input[@id='flight-returning-hp-flight']")
    public WebElement ReturningDates;
    @FindBy(xpath = "//select[@id='hotel-1-adults-hp-hotel']")
    public WebElement AdultCountDropDown;
    @FindBy(css = "select#flight-children-hp-flight")
    public WebElement ChildrenCountDropDown;

    @FindBy(css = "div#hotel-checkin-wrapper-hp-hotel > .datepicker-dropdown .btn-text.close.datepicker-close-btn")
    public WebElement DatePickerClose;

    @FindBy(xpath = "//select[@id='flight-age-select-1-hp-flight']")
    public WebElement Children1AgeDropDown;

    @FindBy(xpath = "//select[@id='flight-age-select-2-hp-flight']")
    public WebElement Children2AgeDropDown;

    @FindBy(xpath = "//select[@id='flight-age-select-3-hp-flight']")
    public WebElement Children3AgeDropDown;

    public void clickFlightTab() {
        scrollToElement(FlightTab);
        RoundTrip.isSelected();
        System.out.println(" user has selected Flights " + FlightTab.getText());
    }

    public void selectNoOfAdults() {
        //# of Adults
        int indexAdults = random.nextInt(3);
        Select list = new Select(AdultCountDropDown);
        list.selectByIndex(indexAdults);
        System.out.println("selected random value between 1 and 3 for Adults :" + indexAdults);
    }

    public void selectNoOfChildren() {
        //#of kids
        int index = random.nextInt(3) + 1;  // Range between 0 to x + 1 because I don't want the 0 option nor the first
        Select kids = new Select(ChildrenCountDropDown);
        kids.selectByIndex(index);
        System.out.println("selected random value between 1 and 4 for Children :" + index);


    }

    public void selectChildrensAgeifChildrenwereSelected() {
        if (Children1AgeDropDown.isDisplayed()) {
            //waitForVisibility(Children1AgeDropDown);
            int index = random.nextInt(17) + 1;
            Select list = new Select(Children1AgeDropDown);
            list.selectByIndex(index);
            System.out.println("selected random value for Kids1 age, between 1 and 17 for Children :" + index);

            if (Children2AgeDropDown.isDisplayed()) {
                //waitForVisibility(Children2AgeDropDown);
                int index2 = random.nextInt(17) + 1;
                Select list2 = new Select(Children1AgeDropDown);
                list2.selectByIndex(index);
                System.out.println("selected random value for Kid #2 age, between 1 and 17 for Children :" + index2);

                if (Children3AgeDropDown.isDisplayed()) {
                   // waitForVisibility(Children3AgeDropDown);
                    int index3 = random.nextInt(17) + 1;
                    Select list3 = new Select(Children1AgeDropDown);
                    list3.selectByIndex(index);
                    System.out.println("selected random value for Kid #3 age, between 1 and 17 for Children :" + index3);

                }
            }
        }
    }

    public void selectARandomFlightFromFlightsTab() throws Exception {

        String enterCity = RandomStringGenerator.selectRandomCity();
        FlyingFromFieldCityOrAirport.sendKeys(enterCity);
        System.out.println("selected city of :" + enterCity);
        //flying to field
        String otherCity = RandomStringGenerator.selectRandomToCity();
        FlyingToFieldCityOrAirport.sendKeys(otherCity);
        System.out.println("selected city of :" + otherCity);
        //Returning Date-
        scrollToElement(ReturningDates);
        //********* Return Date hardcoded to july 15th and random Departing will be 10 days from current date**********//
        ReturningDates.sendKeys("07/15/2020");
        //Departing date
        String enterDate = RandomStringGenerator.getTravelDate();
        DepartingDates.sendKeys(enterDate);
        System.out.println("selected departing date of:"+ enterDate);
        System.out.println("selected return date of:  07/15/2020");
//        ReturningDates.sendKeys(Keys.chord(Keys.COMMAND, "a"));
//        ReturningDates.sendKeys(Keys.chord(Keys.DELETE));


    }

    @FindBy(css = "form#gcw-flights-form-hp-flight .btn-action.btn-primary.gcw-submit")
    public WebElement SearchBtn;

    public void clickSearchButton() {
        scrollToElement(SearchBtn);
        System.out.println(" User has clicked Search Button for results");
    }

}

