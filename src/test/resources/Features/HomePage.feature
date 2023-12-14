#Author: your.email@your.domain.com
Feature: Purple homepage feature

  Background: 
    Given user is on home page

  Scenario: Purple page title
    When user gets the title of the page
    Then page title should be "Indoor Location Services: Comprehensive, Flexible & Proven | Purple"

  Scenario: Purple sectors list
    Then user scrolls down to observe list of sectors covered
      | Banks             |
      | Healthcare        |
      | Hospitality       |
      | Retail            |
      | Stadiums & Arenas |
      | Transport Hubs    |
    And sectors covered count should be 6
