package tests;

import website.HttpRequestStatus;

import org.testng.annotations.Test;


@Test
public class PagesHTTPStatus extends BaseTest {

    HttpRequestStatus getstatus;

    //DEMO TO SHOW HOW TO VALIDATE PAGES IF THEY ARE RETURNING A 200 RESPONSE FROM THE SERVER.****//

    public void validateServerResponseforPages() {
        getstatus = new HttpRequestStatus(driver);

        getstatus.HttpURLStatus("https://www.travelocity.com/Vacation-Packages");
        getstatus.HttpURLStatus("https://www.travelocity.com/Hotels");
        getstatus.HttpURLStatus("https://www.travelocity.com/Cars");
        getstatus.HttpURLStatus("https://www.travelocity.com/Flights");
        getstatus.HttpURLStatus("https://www.travelocity.com/Activities");
        getstatus.HttpURLStatus("https://www.travelocity.com/Cruises");

    }
}
