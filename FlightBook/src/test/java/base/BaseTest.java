package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("baseUrl"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromPort")));

        } catch (Exception e) {

          
            if (driver.getPageSource().contains("Rate exceeded")) {

                System.out.println("⚠ Rate limit hit. Retrying...");

                try {
                    Thread.sleep(3000); // 
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                driver.navigate().refresh();

               
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromPort")));
            }
        }
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

   
    public WebDriver getDriver() {
        return driver;
    }
}