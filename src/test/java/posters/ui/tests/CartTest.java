package posters.ui.tests;

import org.testng.annotations.Test;
import posters.ui.pages.HomePage;
import posters.ui.pages.LoginPage;
import posters.ui.pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        HomePage home = new HomePage(driver);
        home.open();
        home.openUserMenu();
        home.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageLoad();
        loginPage.login("1431908235@qq.com", "12345678");

        // 重新打开首页，确保页面状态干净
        home.open();

        home.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        int cartCount = home.getCartCount();
        assertTrue(cartCount > 0, "购物车数量未增加");
    }
}