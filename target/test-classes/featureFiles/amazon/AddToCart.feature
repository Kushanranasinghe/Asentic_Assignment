Feature: Amazon E-commerce site

  @addToCart
  Scenario Outline: Add an item to cart
    Given I am in amazon home page
    When I search '<searchText>' item
    Then I should see searched item of '<searchText>'
    And I select '<itemNo>' item form search panel
    And I select size as '<size>'
    And I add the item to cart
    Then I should see item in the cart
    Then I should see the item size as "<size>"


    Examples:
      | searchText    | itemNo | size     |
      | shoes for men | 1      |9         |
      | shoes for men | 3      |12         |
      | shoes for men addidas | 3      |9         |
      | shoes for men Rebook | 6      |12         |