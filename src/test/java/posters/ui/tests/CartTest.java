package posters.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        // 登录
        driver.get("http://localhost:8080");
        WebElement menuTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.id("show-user-menu")));
        menuTrigger.click();
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("go-to-login")));
        signInLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("1431908235@qq.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("btn-login")).click();

        // 等待登录后首页加载完成
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // 点击第一个商品（使用包含 /product/ 的链接）
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/product/']")));
        firstProduct.click();

        // 等待详情页加载，点击“Add to Cart”按钮（id="btn-add-to-cart"）
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-add-to-cart")));
        addToCart.click();

        // 等待购物车数量更新（id="header-cart-count"）
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-cart-count")));
        int count = Integer.parseInt(cartBadge.getText());
        assertTrue(count > 0, "购物车数量未增加");
    }
}