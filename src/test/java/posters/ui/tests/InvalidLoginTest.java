package posters.ui.tests;

import org.testng.annotations.Test;
import posters.ui.pages.HomePage;
import posters.ui.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        // 1. 打开首页
        HomePage home = new HomePage(driver);
        home.open();

        // 2. 点击头像 -> 点击 Sign In
        home.openUserMenu();
        home.clickSignIn();

        // 3. 等待登录表单加载
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageLoad();

        // 4. 使用错误密码登录
        loginPage.login("1431908235@qq.com", "wrongpassword");

        // 5. 验证错误提示出现
        assertTrue(loginPage.isErrorDisplayed(), "未显示错误提示");
    }
}