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
        flights.selectARandomFlightFromFlightsTab();
        flights.clickSearchButton();
        wait.until(ExpectedConditions.urlContains("roundtrip"));
    }

    @Test(priority = 2)
    public void displayResults() throws Exception {
        waitForPageLoaded();

    }
}


//    @Test(priority = 2)
//    public void displayRoundTripFlightResults(){
//
//    }
//    @Test(priority = 3)
//    public void selectOneWayTripRandomDataForFlightsTab(){
