Feature: Login Page Feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "OrangeHRM"

  Scenario: Forgot Password Link
    Given user is on login page
    Then forgot password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "OrangeHRM"

  Scenario: Login with incorrect credentials
    Given user is on login page
    When user enters username "Admin"
    And user enters password "admin12"
    And user clicks on Login button
    Then user gets the error saying "Invalid credentials"

  Scenario Outline: Login with the empty password or user name
    Given user is on login page
    When user enters username '<username>'
    And user enters password '<password>'
    And user clicks on Login button
    Then user gets the error saying '<error message>'
    Examples:
      | username | password | error message            |
      | Admin    |          | Password cannot be empty |
      |          | admin123 | Username cannot be empty |
