package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import website.BasePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class RandomStringGenerator extends BasePage {

    public RandomStringGenerator(WebDriver driver) {
        super(driver);

    }

    //****** this class is to DO BOUNDARY TESTING in input fields*****////////

    public static String createRandomName() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        System.out.println(generatedString);
        return generatedString;
    }

    public static String createRandomNumber() {
        String generatedStrings = RandomStringUtils.randomNumeric(10);
        System.out.println(generatedStrings);
        return generatedStrings;
    }

    public static String createRandomccvNumber() {
        String generatedStrings = RandomStringUtils.randomNumeric(3);
        System.out.println(generatedStrings);
        return generatedStrings;
    }

    public static String createRandomAlphnumeric() {
        String generatedStrings = RandomStringUtils.randomAlphanumeric(10);
        System.out.println(generatedStrings);
        return generatedStrings;
    }


    public static String getTravelDate() { //*****    for demo  purposes using small window
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now().plusDays(10);
        String formattedNewDate = localDate.format(dateTimeFormatter);
        return formattedNewDate.toString();
    }



    public static String selectRandomCity() {

        String[] arr1 = {"Miami", "New York", "Paris", "London", "Madrid", "Prague", "Boston", "Dallas", "Rome", "Amsterdam", "Orlando", "Hawaii"};
        Random random = new Random();

        int randomNumber = random.nextInt(arr1.length);

        System.out.println(arr1[randomNumber]);
        return (arr1[randomNumber]);

    }

    public static String selectRandomToCity() {

        String[] arr1 = {"Miami", "New York", "Paris", "London", "Madrid", "Prague", "Boston", "Dallas", "Rome", "Amsterdam", "Orlando", "Hawaii"};
        Random random = new Random();

        int randomNumber = random.nextInt(arr1.length);

        System.out.println(arr1[randomNumber]);
        return (arr1[randomNumber]);

    }

}
