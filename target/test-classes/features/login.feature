Feature: Login Module
@Login1
    Scenario Outline: Verifying login with valid credentials
    Given User is on the OMR Branch hotel page
    When User enter "<userName>" and "<password>" and click login
    Then User should verify success message after login "Welcome Greens"


    Examples: 
      | userName | password |
      | gowtham6306@gmail.com | Gow@2303 |
