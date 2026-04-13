package posters.ui.tests;

import org.testng.annotations.Test;
import posters.ui.pages.HomePage;
import posters.ui.pages.LoginPage;
import posters.ui.pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        // 1. 登录
        HomePage home = new HomePage(driver);
        home.open();
        home.openUserMenu();
        home.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageLoad();
        loginPage.login("1431908235@qq.com", "12345678");

        // 等待登录后首页加载完成
        home.open();

        // 2. 点击第一个商品
        home.clickFirstProduct();

        // 3. 记录添加前的购物车数量
        int oldCount = home.getCartCount();

        // 4. 添加到购物车
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        // 5. 等待购物车数量增加（轮询直到新数量 > 旧数量）
        wait.until(driver -> {
            int current = home.getCartCount();
            return current > oldCount;
        });

        // 6. 验证购物车数量确实增加了
        int newCount = home.getCartCount();
        assertTrue(newCount > 0, "购物车数量未增加");
    }
}