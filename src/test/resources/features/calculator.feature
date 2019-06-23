@calculator
    Feature: Calculator cases

    @calculator1
    Scenario: Verify calculator results
      Given I locate "calculator" page
      When I follow "Financial Calculators"
      And I follow "Auto Loan Calculator"
      And I clear all calculator fields
      And I calculate
      Then I verify "Please provide a positive auto price." calculation error
      Then I verify "Please provide a positive interest value." calculation error
      And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "10" trade-in, "California" state, "7" percent tax, "300" fees
      And I calculate
      Then I verify "$372.67" monthly pay
