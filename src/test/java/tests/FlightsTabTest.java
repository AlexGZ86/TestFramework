package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.RandomStringGenerator;
import website.Flights;

public class FlightsTabTest extends BaseTest {

    Flights flights;

    @Test(priority = 1)
    public void selectRoundTripRandomDataForFlightsTab() throws Exception {
        flights = new Flights(driver);
        //
        flights.clickFlightTab();
        flights.selectNoOfAdults();
        flights.selectNoOfChildren();
        flights.selectChildrensAgeifChildrenwereSelected();
        flights.selectARandomFlightFromFlightsTab();
        flights.clickSearchButton();
        wait.until(ExpectedConditions.urlContains("roundtrip"));

    }

    @Test(priority = 2)
    public void displayRoundTripFlightResults() throws Exception {
        waitForPageLoaded();
        System.out.println("let page display so it shows backend results");
    }
}


//    @Test(priority = 2)
//    public void displayRoundTripFlightResults(){
//
//    }
//    @Test(priority = 3)
//    public void selectOneWayTripRandomDataForFlightsTab(){
