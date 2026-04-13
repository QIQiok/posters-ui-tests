package posters.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addToCartButton = By.id("btn-add-to-cart");
    private By viewCartLink = By.cssSelector("a[href='/en-US/cart']");  // 定位 View Cart 链接

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }


    public void viewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();
    }
}