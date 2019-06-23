@amazon
  Feature: Amazon Scenarios
    @amazon1
    Scenario: Search Amazon for Collectibles
      Given I open Amazon page
      When I initiate search for "Morgan Dollar" in "Collectibles & FineArt" category
      And I set filter Collectible Coin Metal as "Silver"
      And I set sort by "Price: Low to High"
      Then I verify search results
      Then I verify results page

