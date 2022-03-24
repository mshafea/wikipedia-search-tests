Feature: Wikipedia Search

  Background: Go to search page
    Given User landed on "https://en.wikipedia.org/w/index.php?search" Page


  Scenario: Search page elements are displayed as expected
    Then Verify search box is displayed as expected
    And Verify that the search button is displayed as expected


  Scenario Outline: Verify entering valid input and clicking submit returns a result
    When user enters "<keyword>" into search box and click on search button
    Then user should see results with the entered "<keyword>"
    Examples:
      | keyword    |
      | berlin     |


  Scenario Outline: Verify entering invalid input and clicking submit doesn't return a result
    When user enters "<keyword>" into search box and click on search button
    Then user should see "There were no results matching the query."
    Examples:
      | keyword   |
      | @$#@$     |


