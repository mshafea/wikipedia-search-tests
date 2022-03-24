package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.SearchPage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchPageSteps {

    SearchPage searchPage;
    public WebDriver driver;

    public SearchPageSteps() {
        driver = Hooks.driver;
        searchPage = new SearchPage(driver);
    }

    @Given("User landed on {string} Page")
    public void userLandedOnPage(String url) throws IOException {
        driver.get(url);
    }

    @Then("Verify search box is displayed as expected")
    public void verify_search_box_is_displayed_as_expected() {
        assertTrue("The search box is not displayed as expected", searchPage.isSearchBoxDisplayed());
    }

    @Then("Verify that the search button is displayed as expected")
    public void verify_that_the_search_button_is_displayed_as_expected() {
        assertTrue("The search button is not displayed as expected", searchPage.isSearchBtnDisplayed());
    }


    @When("user enters {string} into search box and click on search button")
    public void userEntersIntoSearchBoxAndClickOnSearchButton(String keyword) {
        searchPage.enterSearchKeyword(keyword);
        searchPage.clickOnSearchBtn();
    }

    @Then("user should see results with the entered {string}")
    public void userShouldSeeResultsWithTheEntered(String keyword) {
        assertTrue("The returned results are not as expected", searchPage.getPercentageOfMatchedResult(keyword) > 80);
    }


    @Then("user should see {string}")
    public void user_should_see(String message) {
        assertEquals("The message is not returned as expected", message, searchPage.getNonFoundMessage());
    }

}
