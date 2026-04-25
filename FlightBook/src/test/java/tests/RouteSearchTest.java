package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import base.BaseTest;
import pages.HomePage;
import utils.ConfigReader;

public class RouteSearchTest extends BaseTest {

    @Test(dataProvider = "routes")
    public void testMultipleRoutes(String from, String to) {

        driver.get(ConfigReader.getProperty("baseUrl"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int retries = 3;

        while (retries > 0) {
            try {
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromPort")));
                break;

            } catch (Exception e) {

                if (driver.getPageSource().contains("Rate exceeded")) {
                    System.out.println("⚠ Rate limit in test loop, retrying...");
                    driver.navigate().refresh();
                    retries--;
                } else {
                    throw e;
                }
            }
        }

        HomePage homePage = new HomePage(driver);
        homePage.searchFlight(from, to);
    }

    @DataProvider(name = "routes")
    public Object[][] getRoutes() {
        return new Object[][] {
                {"Boston", "London"},
                {"Paris", "Rome"},
                {"Mexico City", "New York"}
        };
    }
}