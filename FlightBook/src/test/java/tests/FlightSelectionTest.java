package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class FlightSelectionTest extends BaseTest {

    @Test
    public void testFlightSelection() {

        HomePage homePage = new HomePage(driver);
        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage = new FlightListPage(driver);
        flightListPage.selectFirstFlight();

        Assert.assertTrue(driver.getTitle().contains("BlazeDemo"));
    }
}