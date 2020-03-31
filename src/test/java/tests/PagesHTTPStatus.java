package tests;

import website.HttpRequestStatus;

import org.testng.annotations.Test;



@Test
public class PagesHTTPStatus extends TestBase {

   HttpRequestStatus getstatus ;

    public void setup(){
   getstatus = new HttpRequestStatus(driver);
   getstatus.HttpURLStatus("https://www.chenmed.com/news");
        getstatus.HttpURLStatus("https://www.chenmed.com/our-centers");
        getstatus.HttpURLStatus("https://www.chenmed.com/executive-team");
        getstatus.HttpURLStatus("https://www.chenmed.com/contact");
        getstatus.HttpURLStatus("https://www.chenmed.com/blog");
        getstatus.HttpURLStatus("https://www.chenmed.com/about-us");
        getstatus.HttpURLStatus("https://www.chenmed.com/careers");
    }
}
