@converter
  Feature: Converter features

    @converter1
    Scenario: Fahrenheit to Celcius
      Given I go to "converter"  page
      When I click on "Temperature"
      And  I set Fahrenheit to Celcius
      Then I enter into From field "34" and verify "1.1111111111" result


    @converter2
    Scenario: Select tabs
      Given I go to "converter"  page
      When I click on "Time" tab
      And I set From "Hour" value To "Minute" value
      Then I enter into From field "1" and verify "60" result