Feature: Accounts Page Feature

  Background:
    Given User has already logged in to application
      | username | password |
      | Admin    | admin123 |

  Scenario: Accounts page title
    Given user is on the Accounts page
    When user gets the title of the page
    Then page title should be "OrangeHRM"

  Scenario: Accounts Section Count
    Given user is on the Accounts page
    Then user gets accounts section
      | Assign Leave |
      | Leave List    |
      | Timesheets    |
      | Apply Leave   |
      | My Leave      |
      | My Timesheet  |
    And Accounts count should be 6
