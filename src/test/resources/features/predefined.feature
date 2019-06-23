@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@value='Google Search'])[2]"
    Then I wait for element with xpath "//*[@id='ires']" to be present
    Then element with xpath "//*[@id='ires']" should contain text "Cucumber"
  @predefined2
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Selenium Tutorial" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element using JavaScript with xpath "//input[@id='sb_form_go']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Selenium"

  @predefined3
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com/"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "IKEA Furniture" into element with xpath "//input[@id='text']"
    Then I click on element using JavaScript with xpath "//span[contains(text(), 'Search')]"
    Then I wait for element with xpath "//ul[@class='serp-list serp-list_left_yes']" to be present
    Then element with xpath "//ul[@class='serp-list serp-list_left_yes']" should contain text "IKEA"

  @predefined4
  Scenario: Predefined steps for Amazon
    Given I open url "https://www.amazon.com/"
    Then I should see page title contains "Amazon"
    Then element with xpath "//input[@id='twotabsearchtextbox']" should be present
    When I type "Roomba 960" into element with xpath "//input[@id='twotabsearchtextbox']"
    Then I click on element with xpath "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']"
    Then I wait for element with xpath "//div[@class='a-section a-spacing-small a-spacing-top-small']" to be present
    Then  element with xpath "//div[@class='a-section a-spacing-small a-spacing-top-small']" should contain text "Roomba 960"
    When I sw








