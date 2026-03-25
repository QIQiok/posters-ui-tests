package posters.ui.tests;   // 如果包名不同，请修改

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        // 1. 打开首页
        driver.get("http://localhost:8080");

        // 2. 等待页面加载完成
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // 3. 点击下拉菜单触发器（头像图标）
        WebElement menuTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.id("show-user-menu")));
        menuTrigger.click();

        // 4. 等待下拉菜单中的 "Sign In" 链接出现并点击
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("go-to-login")));
        signInLink.click();

        // 5. 等待登录页面加载，邮箱输入框可见
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        // 6. 输入邮箱和密码
        driver.findElement(By.id("email")).sendKeys("1431908235@qq.com");
        driver.findElement(By.id("password")).sendKeys("12345678");

        // 7. 点击登录按钮
        driver.findElement(By.id("btn-login")).click();

        // 8. 等待页面跳转回首页，等待 body 出现（确保页面已刷新）
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // 9. 再次点击头像图标，展开下拉菜单
        WebElement menuTriggerAfterLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("show-user-menu")));
        menuTriggerAfterLogin.click();

        // 10. 等待 Logout 链接出现（在下拉菜单中）
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("go-to-logout")));
        assertTrue(logoutLink.isDisplayed(), "登录失败，未找到 Logout 链接");
    }
}
