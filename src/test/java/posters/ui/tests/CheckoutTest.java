package posters.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import posters.ui.pages.*;

import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {
        // 1. 登录
        HomePage home = new HomePage(driver);
        home.open();
        home.openUserMenu();
        home.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageLoad();
        loginPage.login("1431908235@qq.com", "12345678");

        // 等待登录后首页加载
        home.open();

        // 2. 点击第一个商品
        home.clickFirstProduct();

        // 3. 添加到购物车
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        // 4. 点击 View Cart 进入购物车页面
        productPage.viewCart();

        // 5. 等待购物车页面加载完成（假设有一个唯一元素 #cart-content）
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart-content"))); // 请根据实际页面调整

        // 6. 登出
        home.openUserMenu();
        driver.findElement(By.id("go-to-logout")).click();

        // 7. 等待登出后页面刷新，重新进入购物车页面（可以直接访问购物车 URL）
        driver.get("http://localhost:8080/en-US/cart"); // 根据实际购物车 URL 调整
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart-content"))); // 再次等待购物车内容加载

        // 8. 点击 Checkout 按钮
        driver.findElement(By.id("btn-checkout")).click();

        // 9. 验证跳转到结算地址页面
        assertTrue(wait.until(ExpectedConditions.urlContains("/checkout/shippingAddress")),
                "未进入结算页面");
    }
}