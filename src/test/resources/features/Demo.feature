Feature: Demo Page Test

  Scenario: Verify Login Page and Links
    Given User is on the Demo page
    When User clicks on login button
    Then Login page is displayed in new tab
    And Email and Password fields are present
    And Switch back to Demo tab
    Then Get all links and verify their status
