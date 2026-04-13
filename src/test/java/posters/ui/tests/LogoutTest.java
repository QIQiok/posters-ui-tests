package posters.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import posters.ui.pages.HomePage;
import posters.ui.pages.LoginPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        // 1. 登录
        HomePage home = new HomePage(driver);
        home.open();
        home.openUserMenu();
        home.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageLoad();
        loginPage.login("1431908235@qq.com", "12345678");

        // 等待登录完成，重新打开首页（确保页面状态）
        home.open();

        // 2. 打开用户菜单，等待 Logout 链接出现
        home.openUserMenu();
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("go-to-logout")));
        assertTrue(logoutLink.isDisplayed(), "登录后未找到 Logout 链接");

        // 3. 点击 Logout 链接
        logoutLink.click();

        // 4. 等待页面跳转回首页，确保页面加载完成
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // 5. 再次打开菜单，验证 Logout 链接不存在
        home.openUserMenu();
        // 使用 findElements 避免等待超时
        boolean isLogoutPresent = !driver.findElements(By.id("go-to-logout")).isEmpty();
        assertFalse(isLogoutPresent, "Logout 仍然存在，登出失败");
    }
}