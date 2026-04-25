package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By fromCity = By.name("fromPort");
    private By toCity = By.name("toPort");
    private By findFlightsBtn = By.cssSelector("input[type='submit']");

    public void searchFlight(String from, String to) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCity));

        Select fromDropdown = new Select(driver.findElement(fromCity));
        fromDropdown.selectByVisibleText(from);

        Select toDropdown = new Select(driver.findElement(toCity));
        toDropdown.selectByVisibleText(to);

        click(findFlightsBtn);
    }
}