package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class FlightSearchTest extends BaseTest {

    @Test
    public void testFlightSearch() {

        HomePage homePage = new HomePage(driver);
        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage = new FlightListPage(driver);

        Assert.assertTrue(flightListPage.isFlightDisplayed());
    }
}