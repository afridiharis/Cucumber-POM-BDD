#Author: your.email@your.domain.com
Feature: Purple partners portal feature

  Background: 
    Given user is on partners portal page

  Scenario: Partners Portal
    When user gets the title of the page
    Then page title should be "Useful Documentation and Sales Collateral | Purple Partner Portal"

  Scenario: Login with incorrect email
    When user enters username "qa@test.com"
    And user clicks on Login button
    Then user should get an error message "Unknown email address. Please check again."
