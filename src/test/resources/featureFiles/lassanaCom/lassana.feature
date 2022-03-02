@cna
Feature: CNA page verification
  @sc1
  Scenario Outline: Verify product search in lassana.com
    Given Given I am landing in lassana.com and validate the page title
    When I search '<product_name>' item in lassana site
    Then  I  verify the search text value as '<product_name>' in result page
    When I redirect to the '<product_name>'  page
    Then I verify the page title
    When I click on Logo on left top corner
    Then I verify the page title

    Examples:
    |product_name|
    |PINEAPPLE MERINGUE CAKE 1.5kg (3.3lbs)|


