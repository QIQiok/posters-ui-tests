package posters.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        // 1. 打开首页
        driver.get("http://localhost:8080");

        // 2. 点击下拉菜单触发器（头像图标）
        WebElement menuTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.id("show-user-menu")));
        menuTrigger.click();

        // 3. 点击 Sign In 链接
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("go-to-login")));
        signInLink.click();

        // 4. 等待登录表单加载
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        // 5. 输入正确邮箱，错误密码
        driver.findElement(By.id("email")).sendKeys("1431908235@qq.com");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");

        // 6. 点击登录按钮
        driver.findElement(By.id("btn-login")).click();

        // 7. 等待错误提示出现（页面显示红色错误信息）
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-danger")));
        assertTrue(errorMsg.isDisplayed(), "未显示错误提示");
    }
}