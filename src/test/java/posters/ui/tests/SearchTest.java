package posters.ui.tests;

import org.testng.annotations.Test;
import posters.ui.pages.HomePage;
import posters.ui.pages.SearchResultPage;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void testSearch() {
        // 1. 打开首页
        HomePage home = new HomePage(driver);
        home.open();

        // 2. 执行搜索
        home.search("mountain");

        // 3. 获取搜索结果页面对象，验证结果数量大于0
        SearchResultPage searchResult = new SearchResultPage(driver);
        int productCount = searchResult.getProductCount();
        assertTrue(productCount > 0, "搜索结果为空");
    }
}