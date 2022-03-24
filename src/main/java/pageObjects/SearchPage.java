package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase {

    @FindBy(id = "firstHeading")
    private WebElement searchPageHeader;

    @FindBy(id = "ooui-php-1")
    private WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    private WebElement searchBtn;

    @FindBy(css = "p.mw-search-nonefound")
    private WebElement searchNonFoundMsg;

    @FindBy(css = "div.mw-search-result-heading span.searchmatch")
    private List<WebElement> searchResultsMatchedHeadeing;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchBoxDisplayed() {
        return isElementDisplayed(searchBox);
    }

    public boolean isSearchBtnDisplayed() {
        return isElementDisplayed(searchBtn);
    }

    public void enterSearchKeyword(String keyword){
        setText(searchBox,keyword);
    }

    public void clickOnSearchBtn(){
        click(searchBtn);
    }

    public String getNonFoundMessage(){
        return getElementText(searchNonFoundMsg);
    }

    public double getPercentageOfMatchedResult(String searchKeyword) {
        int count = 0;
        double size = searchResultsMatchedHeadeing.size();
        for (WebElement element : searchResultsMatchedHeadeing) {
            if (getElementText(element).toLowerCase().contains(searchKeyword.toLowerCase())) count++;
        }
        return (count / size) * 100;
    }

}
