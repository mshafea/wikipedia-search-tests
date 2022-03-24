package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    public int time = 30;
    private int frequency = 1;
    Actions action;
    private FluentWait<WebDriver> fluentWait;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        fluentWait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(time)).
                pollingEvery(Duration.ofSeconds(frequency)).
                ignoring(NoSuchElementException.class).
                ignoring(TimeoutException.class).
                ignoring(StaleElementReferenceException.class);
    }

    public void click(WebElement element) {
        element.click();
    }


    public void setText(WebElement element, String text) {
        waitForVisibilityOf(element);
        element.clear();
        element.sendKeys(text);
    }


    public String getElementText(WebElement element) {
        try {
            element.isDisplayed();
            return element.getText().trim();
        } catch (NoSuchElementException e) {
            return ("No such element exception is returned");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (TimeoutException t) {
            return false;
        } catch (StaleElementReferenceException se) {
            return false;
        }
    }

    public void waitForVisibilityOf(final WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }


}
