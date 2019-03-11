Feature: Filter
  As an end user
  I want to apply filter
  So that I can view the results based on Filter


  @wip
  Scenario: Search for a product
    Given I am on homepage
    When  I search for a product "nike"
    And   All the relevant products should be displayed
    And   I apply filter "2or more" on search result
    Then  I should see all products "review" are filtered "2.0"


  @regression
  Scenario: Filter by Price range
    Given I am on homepage
    When  I search for a product "nike"
    And   All the relevant products should be displayed
    And   I apply filter "£10 - £15" on search result
    Then  I should see all products "range" are filtered "10-15"

  @regression
  Scenario: Filter by Category
    Given I am on homepage
    When I search for a product "nike"
    And I apply filter "Running" on search result
    Then I should see all products "category" are filtered "Running"








