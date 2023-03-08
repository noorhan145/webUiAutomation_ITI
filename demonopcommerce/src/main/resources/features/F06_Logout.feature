@smoke
Feature: F06_Logout | users could use logout functionality
  Scenario: user could logout from the system
    Given user is logged in
    When user click on logout icon
    Then user logout from the system successfully