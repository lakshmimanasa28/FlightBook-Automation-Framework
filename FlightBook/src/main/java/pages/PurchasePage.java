package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class PurchasePage extends BasePage {

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    private By name = By.id("inputName");
    private By address = By.id("address");
    private By city = By.id("city");
    private By state = By.id("state");
    private By zipCode = By.id("zipCode");

    private By cardType = By.id("cardType");
    private By cardNumber = By.id("creditCardNumber");

    private By cardMonth = By.id("creditCardMonth");
    private By cardYear = By.id("creditCardYear");

    private By nameOnCard = By.id("nameOnCard");
    private By purchaseBtn = By.cssSelector("input[type='submit']");

    public void completePurchase(String userName, String addr, String cityName,
                                 String stateName, String zip,
                                 String cardNum, String month, String year,
                                 String cardHolderName) {

        type(name, userName);
        type(address, addr);
        type(city, cityName);
        type(state, stateName);
        type(zipCode, zip);

        Select select = new Select(driver.findElement(cardType));
        select.selectByVisibleText("Visa");

        type(cardNumber, cardNum);
        type(cardMonth, month);
        type(cardYear, year);
        type(nameOnCard, cardHolderName);

        click(purchaseBtn);
    }
}