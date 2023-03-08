@smoke
Feature: F03_currencies | users could choose currency
  Scenario: user could choose Euro currency
    When user select Euro currency from the dropdown list
    Then user show products with Euro Symbol displayed in Home page
    