package posters.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void testSearch() {
        driver.get("http://localhost:8080");

        // 等待搜索框出现，name 属性为 "q"
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchInput.sendKeys("mountain");

        // 点击搜索按钮（假设按钮 type="submit"）
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // 等待结果列表加载（商品卡片 class 为 "card"）
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));

        List<WebElement> products = driver.findElements(By.className("card"));
        assertTrue(products.size() > 0, "搜索结果为空");
    }
}