@webdriver
    Feature: Webdriver functions

    @webdriver1
    Scenario: Open page
      Given I go to "google" page and print details
      And I go to "sample" page and print details
      And I go back and forward then refresh the page
      And I print logs to the console


    @webdriver2
    Scenario: Looping though urls
      Given I open "https://www.yandex.com/" then "https://www.bing.com/" then "https://www.yahoo.com/"

    @webdriver3
    Scenario: Working with window sizes
      Given   I go to "sample" page and print details
      And I change resolution to "phone"
      And I change resolution to "desktop"
      And I maximize window


    @webdriver4
    Scenario: Element steps
      Given I go to "sample" page and print details
      When I fill out first name "Galina" and last name "Lagunova"
      When I verify email field behavior
      When I fill out required fields
      When I submit the form
      Then I verify submitted data


    @webdriver5
    Scenario: Selection list
      Given I go to "sample" page and print details
      When I select "Pakistan" as country of origin

    @webdriver6
    Scenario: Calendar picker
      Given I go to "sample" page and print details
      When I choose "06/10/1954" as date of birth

    @webdriver7
    Scenario: Text selected
      Given I go to "sample" page and print details
      When I specify "Toyota" as an option


    @webdriver8
    Scenario: Alert message
      Given I go to "sample" page and print details
      When I click on element with xpath "//button[@id='thirdPartyButton']"
      When I read a warning message
      Then I accept alert

    @webdriver9
    Scenario: Application summary
      Given I go to "sample" page and print details
      When I click on element with xpath "//div[@class='well form-summary']"
      Then I check "Application" is displayed

    @webdriver10
    Scenario: Choose file
      Given I go to "sample" page and print details
      When I click on element with xpath "//input[@id='attachment']"
      When I attach file "12791605.gif"









