@confusion
  Feature: Confusion Scenarios

    @confusion1
    Scenario: Login steps
      Given I navigate to "confusion" url
      And I provide "Login" username "gplagun" and password "Selenium"
      Then I verify alert message contains "gplagun"
      Then I verify alert message contains "Selenium"
      And  I accept alert message

    @confusion2
    Scenario: Menu - Submit Feedback
      Given I navigate to "confusion" url
      And I go to the tab "Menu"
      And I select "Uthappizza" from menu
      And I click on element "Submit Comment"
      And I choose rating "3"
      When I indicate my name "Galina"
      And I provide comment "Test comment"
      And I submit my comment
      Then I verify that text "Galina" is displayed on the page
      Then I verify that text "Test Comment" is displayed on the page

    @confusion3
    Scenario: Verify Jumbotron
      Given I navigate to "confusion" url
      And I verify jumbotron elements

    @confusion4
    Scenario: Verify Navbar
      Given I navigate to "confusion" url
      When I move  to navigation bar
      And I verify logo
      And I move to "About" page and check current url

    @confusion5
    Scenario: Verify navigation by back and forward buttons
      Given I navigate to "confusion" url
      And I move to "About" page and check current url
      And I move to "Menu" page and check current url
      And I move to "Contact" page and check current url
      When I go back to "Menu" and check current url
      Then I go back and forward to "Contact" and check current url

    @confusion6
    Scenario: Verify Contact Us
      Given I navigate to "confusion" url
      And I move to "Contact" page and check current url
      And I enter firstname "Galina" lastname "Lagunova" phone "6502158701" email "gplagun@yahoo.com"
      And I select contact as "Email"
      And I provide the following feedback "Test message FEEDBACK"
      Then I verify alert message contains "Test message FEEDBACK"
      And  I accept alert message















