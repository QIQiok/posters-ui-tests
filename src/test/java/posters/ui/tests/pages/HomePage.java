package posters.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // 元素定位器
    private By userMenuTrigger = By.id("show-user-menu");
    private By signInLink = By.id("go-to-login");
    private By searchInput = By.name("keyword");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By firstProduct = By.cssSelector(".product-item a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("http://localhost:8080");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public void openUserMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userMenuTrigger)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    public void search(String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }
}
