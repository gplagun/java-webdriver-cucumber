@usps
  Feature: Webdriver functions

    @usps1
    Scenario: Validate ZIP code for Portnov Computer School address
      Given  I go to "usps"  page
      When I go to Lookup ZIP page by address
      And I fill out "4970 El Camino Real" street "Los Altos" city "CA-California" state
      Then I validate that "94022" exists in result

    @usps2
    Scenario: Validate Zip code for company address
      Given  I go to "usps"  page
      When I go to Lookup ZIP page by address with mouseover
      And I fill out "5805 Owens Dr" street "Pleasanton" city "CA" state
      Then I validate that "94588" exists in result

    @usps3
    Scenario: Calculate Price
      Given  I go to "usps"  page
      When I go to Calculate Price page
      When I select "Turkey" with "Postcard" shape and define "2" quantity"
      Then I calculate the price and validate cost is "2.30"

    @usps4
    Scenario: Did not match
      Given  I go to "usps"  page
      When I navigate to "Postal Store" menu item
      And I enter "12345" into store search
      Then I verify search didn't match any results

     @usps5
     Scenario: Validate Fahrenheit to Celcius
       Given  I go to "converter"  page
       When I go to "Temperature" tab
       And I should see page title from "Fahrenheit" to "Celcius"
       Then I enter from "5" and verify to is "-15"

     @usps6
     Scenario: One item found
       Given  I go to "usps"  page
       When I go to Stamps and Supplies page
       And I open Stamps
       And I choose category Priority Mail
       Then I verify 1 item found in result

      @usps7
      Scenario: Verify color
        Given  I go to "usps"  page
        When I go to Stamps and Supplies page
        And I open Stamps
        When I unselect Stamps checkbox
        And I select size "Medium"
        And I click color "orange"
        Then I verify “Vintage U.S. Postage T-Shirt” text
        Then I verify "orange" color and  "Medium" size filters

     @usps8
     Scenario: Verify location
       Given  I go to "usps"  page
       And I initiate "Passport" search
       And I go to Post Office Hours results
       And I select "Passports" location "94568" zip code within "20 miles"
       And I initiate search
       Then I verify "Plesanton" search results

    @usps9
    Scenario: Validate ZIP code page object
      Given I go to usps page object
      When I go to Lookup ZIP page by address with page object
      Then I verify ZIP by address with page object

    @usps10
    Scenario: Calculate price logic page object
      Given I go to usps page object
      When I go to Calculate Price page object
      And I select "Turkey" with "Postcard" shape
      And I define "2" quantity page object
      Then I calculate the price and validate cost is "2.30" page object

    @usps11
    Scenario: Did not match with page object
      Given I go to usps page object
      When I navigate to "Postal Store" menu item with page object
      And I enter "12345" into store search with page object
      Then I verify that search did not match any results

    @usps12
    Scenario: One item found with page object
      Given I go to usps page object
      When I go to Stamps and Supplies page with page object
      And I choose category "Priority Mail" with page object


    @usps13
    Scenario Outline: Validate ZIPs for company address outline
      Given  I go to "usps"  page
      When I go to Lookup ZIP page by address with mouseover
      And I fill out "<address>" street "<city>" city "<state>" state
      Then I validate that "<zipResult>" exists in result
      Examples:
      | address             | city        | state | zipResult |
      | 5805 Owens Dr       | Pleasanton  | CA    | 94588     |
      | 4970 El Camino Real | Los Altos   | CA    | 94022     |
      | 485 Wilson Ave      | Sunnyvale   | CA    | 94086     |











