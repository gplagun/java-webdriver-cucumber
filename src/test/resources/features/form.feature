@form
  Feature: Form Scenarios
    @form1
    Scenario: Submit and verify the form
      Given I go to "sample" page
      When I fill out all fields
      And I submit the form
      Then I verify all filled out fields

    @form2
    Scenario: Submit and verify page object form
      Given I open sample page
      When I fill out all page object fields
      And I submit shipment form and verify new page object form
      Then I verify all page object fields

    @form3
    Scenario: Verify password accepts at lest 5 characters
      Given I open sample page
      Then I verify application date is today's date
      When I verify confirm password field is disabled
      And I verify that password field requires 5 characters
      And I verify that password field is masked

    @form4
    Scenario:  Verify page object negative cases
      Given I open sample page
      When I verify confirm password field is enabled when password filled
      And I verify that email does not  accept invalid format
      And I fill out contact person name
      And I fill out contact person phone

    @form5
    Scenario: Verify incorrect email entries
      Given I open sample page
      When I verify that email doesn't accept "<email>" format
      Examples:
      | email |
      | slava#skryabim.com |
      | slava%skryabim.com |
      | slava$skryabim.com |
      | slava&skryabim.com |
      | completelyInvalid |
      | ANOTHER |
      | StilWrong |







