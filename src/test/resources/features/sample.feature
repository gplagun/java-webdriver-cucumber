@sample
  Feature: Predefined steps for Sample page
    @sample1
    Scenario: Responsive Ui test
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I resize window to 1280 and 1024
      Then element with xpath "//b[@id='location']" should be displayed
      When I resize window to 400 and 1024
      Then element with xpath "//b[@id='location']" should not be displayed

    @sample2
    Scenario: Username field min length text
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='username-error']" should be displayed
      Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
      When I clear element with xpath "//input[@name='username']"
      When I type "aa" into element with xpath "//input[@name='username']"
      When I scroll to the element with xpath "//button[@id='formSubmit']" with offset 50
      When I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='username-error']" should not be displayed

    @sample3
    Scenario: Validation of Name
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I maximize window
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
      When I type "Galina" into element with xpath "//input[@id='firstName']"
      When I type "Lagunova" into element with xpath "//input[@id='lastName']"
      When I click on element with xpath "//span[contains(text(),'Save')]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Galina Lagunova"


    @sample4
    Scenario: Validation of DOB
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//input[@id='dateOfBirth']"
      Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
      When I click on element with xpath "//a[@data-handler='prev']"
      Then  element with xpath "//select[@data-handler='selectMonth']/option[@value='3']" should be selected
      When I click on element with xpath "//a[@data-handler='next']"
      Then  element with xpath "//select[@data-handler='selectMonth']/option[@value='4']" should be selected
      When I click on element with xpath "//select[@data-handler='selectMonth']/option[@value='5']"
      When I click on element with xpath "//select[@ data-handler='selectYear']/option[@value='1954']"
      When I click on element with xpath "//a[contains(text(),'10')]"
      Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "06/10/1954"
      
      
    @sample5
    Scenario: Validation of Contacts in iFrame
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
      When I type "James Morgan" into element with xpath "//input[@id='contactPersonName']"
      When I type "(650) 960-4699" into element with xpath "//input[@id='contactPersonPhone']"
      Then element with xpath "//input[@id='contactPersonName']" should have attribute "value" as "James Morgan"
      Then element with xpath "//input[@id='contactPersonPhone']" should have attribute "value" as "(650) 960-4699"
      And  I switch to default content
      When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"


    @sample6
    Scenario: Validation of alert
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//button[@id='thirdPartyButton']"
      Then I accept alert

    @sample7
    Scenario: Validation of new windows
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//*[contains(@onclick, 'new_window')]"
      When I switch to new window
      Then element with xpath "/html" should contain text "Document 2"
      When I switch to first window

    @sample8
    Scenario:  Validation of the country of origin
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//select[@name='countryOfOrigin']//option[contains(text(),'Other')]"
      Then element with xpath "//select[@name='countryOfOrigin']" should have attribute "value" as "Other"

    @sample9
    Scenario:  Validation of Car Make
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//select[@name='carMake']//option[contains(text(),'Toyota')]"
      Then element with xpath "//select[@name='carMake']//option[contains(text(),'Toyota')]" should be selected
      
      



      





      
      
      



