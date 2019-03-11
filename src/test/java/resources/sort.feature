Feature: Sort By
  As an end user
  I want to sort based on price
  So that I can view the results

  Scenario: Search for a product
    Given I am on homepage
    When  I search for a product "nike"
    And   All the relevant products should be displayed
    And   I select "Low - High" Option
    Then  I should see the results
