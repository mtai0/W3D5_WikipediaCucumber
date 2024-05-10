Feature: Users can view different Wikipedia homepages for each language.
  Background: User is on Wikipedia homepage
    Given user is on the Wikipedia homepage

  Scenario: Users can view the Wikipedia homepage for the English language.
    When user clicks on the button for the English portal
    Then user is taken to the English homepage

  Scenario: Users can view the Wikipedia homepage for the Spanish language.
    When user clicks on the button for the Spanish portal
    Then user is taken to the Spanish homepage

  Scenario: Users can view the Wikipedia homepage for the Deutsch language.
    When user clicks on the button for the Deutsch portal
    Then user is taken to the Deutsch homepage
