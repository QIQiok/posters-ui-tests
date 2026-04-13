package posters.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addressLine = By.id("addressLine");
    private By city = By.id("city");
    private By zip = By.id("zip");
    private By submitButton = By.id("btn-submit");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillAddress(String address, String cityName, String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLine)).sendKeys(address);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(zip).sendKeys(zipCode);
        driver.findElement(submitButton).click();
    }
}