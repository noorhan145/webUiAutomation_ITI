@smoke
Feature: F08_AddToCart | users could add products to card
  Scenario: user could could add products to card successfully
    Given user go to one of categories page
    When user click on 'ADD TO CART' button of the first product
    And user click on 'ADD TO CART' button of the second product
    And user click on 'ADD TO CART' button of the second product again
    And user navigate to shopping cart
    Then products added to the shopping cart
    And the subTotal is correct