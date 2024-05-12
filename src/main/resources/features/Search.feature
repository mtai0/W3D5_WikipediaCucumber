Feature: Users can search for topics
  Background: User is on the Wikipedia homepage
    Given user is on the Wikipedia homepage
    And user has their search language set to English

  Scenario Outline: Search for exact topic
    Given "<searchTerm>" is the name of an existing Wikipedia article
    When user searches for "<searchTerm>"
    Then user is taken to the Wikipedia page for "<searchTerm>"
    Examples:
      | searchTerm |
      | banana |
      | apollo |
      | julius caesar |

  Scenario Outline: Search for nonexistent topic
    Given no page exists for "<searchTerm>"
    When user searches for "<searchTerm>"
    Then user is told that no results were found
    Examples:
      | searchTerm |
      | alskdjfh |
      | ;;;;;;;; |
      | 14329814903253957389042750932 |

  Scenario Outline: Search for partial match
    Given no page exists for "<searchTerm>"
    And "<searchTerm>" is a term that appears in one or more Wikipedia pages
    When user searches for "<searchTerm>"
    Then user is shown a list of articles that contain a match for "<searchTerm>"
    Examples:
      | searchTerm |
      | something that happened |
      | events of the 1980s |
      | cool animals |