@smoke
Feature: F03_hoverCategories | users could hover on category
  Scenario: user could hover on one of 3 main categories contains sub-categories
    When user hover on random one of the three main categories
    And user select random one of the three sub categories
    Then user show the selected sub category page

  Scenario: user could hover on one of main categories
    When user hover on any random category whether it contains sub category or not
    And user select either random one of sub categories or one of the main categories that not contains sub category
    Then user show the selected sub category page