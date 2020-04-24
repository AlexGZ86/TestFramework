package website;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.RandomStringGenerator;

import java.util.stream.IntStream;

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
    @FindBy(xpath = "//select[@id='flight-adults-hp-flight']")
    public WebElement AdultCountDropDown;


    @FindBy(xpath = "//html//div[@id='flight-returning-wrapper-hp-flight']//div[@class='datepicker-close']/button[@type='button']")
    public WebElement DatePickerCloseBtn;



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
        System.out.println("selected random value between default index'0' equals 1, and 3 for Adults :" + indexAdults );
    }





        public void selectARandomFlightFromFlightsTab () throws Exception {

            String enterCity = RandomStringGenerator.selectRandomCity();
            FlyingFromFieldCityOrAirport.sendKeys(enterCity);
            System.out.println("selected city of :" + enterCity);
            //flying to field
            String otherCity = RandomStringGenerator.selectRandomToCity();
            FlyingToFieldCityOrAirport.sendKeys(otherCity);
            System.out.println("selected city of :" + otherCity);
            //Returning Date-
            String enterDate = RandomStringGenerator.getTravelDate();
            DepartingDates.sendKeys(enterDate);
            System.out.println("selected departing date of:" + enterDate);

            scrollToElement(ReturningDates);
            DatePickerCloseBtn.click();
//        driver.findElement(By.xpath("//html//div[@id='flight-returning-wrapper-hp-flight']//div[@class='datepicker-close']/button[@type='button']")).click();

//        for (int i = 0; i > 10; i++) {
//            lenText1.sendKeys(Keys.BACK_SPACE);
//            Thread.sleep(3000);
//        }

            IntStream.range(0, 10).forEach(i -> ReturningDates.sendKeys(Keys.BACK_SPACE));

            ReturningDates.click();
            //********* Return Date hardcoded to july 15th and random Departing will be 10 days from current date**********//
            ReturningDates.sendKeys("06/15/2020");

        }

        @FindBy(css = "form#gcw-flights-form-hp-flight .btn-action.btn-primary.gcw-submit")
        public WebElement SearchBtn;

        public void clickSearchButton () {
            scrollToElement(SearchBtn);
            System.out.println(" User has clicked Search Button for results");
        }
    }

