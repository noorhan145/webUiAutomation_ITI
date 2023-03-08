@smoke
Feature: F07_ContactUs | users could use contact us functionality
  Scenario: user could sent his enquiry successfully
    When user click on 'Contact us' link
    And user enter his name in 'Your name' field
    And user enter his email in 'Your email' field
    And user enter his enquiry in 'enquiry' field
    And user click 'Submit' button
    Then user enquiry has been successfully sent