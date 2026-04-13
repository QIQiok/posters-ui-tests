package posters.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userMenuTrigger = By.id("show-user-menu");
    private By signInLink = By.id("go-to-login");
    private By searchInput = By.name("q");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By firstProductLink = By.cssSelector("a[href*='/product/']");
    private By logoutLink = By.id("go-to-logout");
    private By cartCount = By.id("header-cart-count");

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
        wait.until(ExpectedConditions.elementToBeClickable(firstProductLink)).click();
    }

    public boolean isLogoutDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
    }

    public int getCartCount() {
        // 直接等待元素可见并返回文本，避免 stale
        String text = wait.until(driver -> {
            try {
                return driver.findElement(cartCount).getText();
            } catch (Exception e) {
                return null;
            }
        });
        return Integer.parseInt(text);
    }
}