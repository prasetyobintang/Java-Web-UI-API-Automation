Feature: Test Automation Rest API

  @web
  Scenario: Test web login normal
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login