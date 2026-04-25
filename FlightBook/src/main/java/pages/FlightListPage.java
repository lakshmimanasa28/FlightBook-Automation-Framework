package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import base.BasePage;

public class FlightListPage extends BasePage {

    public FlightListPage(WebDriver driver) {
        super(driver);
    }

    private By chooseBtn = By.cssSelector("input[type='submit']");
    private By rows = By.cssSelector("table tbody tr");

    
    public void selectFirstFlight() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> driver.findElements(chooseBtn).size() > 0);

        List<WebElement> elements = driver.findElements(chooseBtn);

        if (elements.size() == 0) {
            throw new RuntimeException("No flights found!");
        }

        elements.get(0).click();
    }

   
    public int getFlightCount() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> driver.findElements(rows).size() > 0);

        return driver.findElements(rows).size();
    }

    public boolean isFlightDisplayed() {
        return getFlightCount() > 0;
    }
}