 Feature: Test automation for saucedemo
  @saucedemo_buy
  Scenario Outline: Verify user can buy an item from saucedemo
    Given Given I am landing in saucedemo.com and validate the page title
    When I log into the system with user name '<user>' and password '<password>'
    And I sort the products by price with criteria '<criteria>'
    When I add the '3' cheapest products to my basket
    And I open the basket
    When I remove the product from basket price value less than '8'
    And I checkout the cart
    When I enter first name '<fName>' last name '<lName>' and zip code '<zipCode>'
    Then I should see CHECKOUT: OVERVIEW page
    And I click finish button to complete the process
    Then I should see success message as 'THANK YOU FOR YOUR ORDER'

    Examples:
      |user|password|criteria|fName|lName|zipCode|
      |standard_user|secret_sauce|Price (high to low)|Kusan|Ranasinghe|12400|


