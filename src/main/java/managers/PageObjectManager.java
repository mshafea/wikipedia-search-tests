package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.SearchPage;

public class PageObjectManager {

    private WebDriver driver;
    private SearchPage searchPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage getSearchPage() {
        return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
    }

}
