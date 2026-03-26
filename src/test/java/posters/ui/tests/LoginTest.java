package posters.ui.tests;

import org.testng.annotations.Test;
import posters.ui.pages.HomePage;
import posters.ui.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        // 1. 创建 HomePage 对象并打开首页
        HomePage home = new HomePage(driver);
        home.open();

        // 2. 打开用户菜单并点击 Sign In
        home.openUserMenu();
        home.clickSignIn();

        // 3. 创建 LoginPage 对象，等待页面加载，执行登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageLoad();
        loginPage.login("1431908235@qq.com", "12345678");

        // 4. 登录后回到首页，再次打开用户菜单，验证 Logout 链接出现
        home.openUserMenu();
        assertTrue(home.isLogoutDisplayed(), "登录失败，未找到 Logout 链接");
    }
}