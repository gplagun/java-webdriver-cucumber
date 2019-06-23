@prosper
  Feature: Prosper Scenario
    @prosper1
    Scenario: Get your rate
      Given I go to Prosper page object
      When I click "Check your rate"
      And I fill out loan data fields
      And I fill out personal information fields
      And I fill out income information fields
      And I fill out contact information
      And I fill out email and password
      And I check electronic signature
      And I submit custom rate form
      Then I verify that SSN page is loaded


