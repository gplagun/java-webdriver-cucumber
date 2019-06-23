@ups
  Feature: UPS Scenarios

    @ups1
    Scenario: Verify UPS shipping functionality
      Given I go to "ups" page
      When I open "Shipping" menu item
      And I open "Calculate Time & Cost" submenu item
      And I submit calculation form
      Then I verify ">>> Please complete the highlighted fields." form error
      And I verify ">>> City" form error
      And I verify ">>> ZIP Code" form error
      When I enter from "Los Altos" and "94022" zip
      And I enter to "New York" and "10165"zip
      And I submit calculation form
      And I enter "1" lbs weight
      And I submit calculation form
      Then I verify results contain "Los Altos" text
      Then I verify results contain "New York" text
      Then I verify results contain "UPS Next Day Air® Early" text
      Then I verify results contain "UPS 2nd Day Air®" text
      Then I verify results contain "UPS Ground" text

    @ups2
    Scenario: Verify ship and cost
      Given I go to "ups" page
      When I open "Shipping" menu item
      And I open "Create a Shipment:" submenu item
      And I fill out "country" dropdown with "United States"
      And I submit shipment form
      Then I verify "Name" field has error "Name is required"
      Then I verify "Address" field has error "Address Line 1 is required"
      Then I verify "State" field has error "State is required"
      Then I verify "Zip" field has error "ZIP Code is required"
      Then I verify "City" field has error "City is required"
      When I fill out "Email" field with "aaa"
      Then I verify "Email" field has error "Email format is invalid"
      When I clear "email" field
      And I clear "phone" field
      When I fill out "Name" field with "Los Altos Testing House"
      And I fill out "Contact" field with "Administrator"
      And I fill out "Address" field with "4970 El Camino Real"
      And I fill out "ZIP Code" field with "94022"
      And I fill out "City" field with "Los Altos"
      And I fill out "state" dropdown with "California"
      And I fill out "Email" field with "slava@skryabin.com"
      And I fill out "Phone" field with "650-215-0000"
      And I submit shipment form
      Then I verify that ship from section contains "Los Altos Testing House"
      Then I verify that ship from section contains "4970 El Camino Real"
      Then I verify that ship from section contains "slava@skryabin.com"
      And I cancel shipment
      Then I verify shipment is cancelled

    @ups3
    Scenario: Verify ship and cost with different locale
      Given I go to "ups" page
      When I change to a different locale
      And I change region to "Europe", country to "Deutschland - Deutsch"
      When I open "Versand" menu item
      And I open "Erstellen einer Sendung:" submenu item
      And I fill out "country" dropdown with "USA"
      And I submit shipment form
      Then I verify "Name" field has error "Name ist erforderlich"
      Then I verify "Adresse" field has error "Adresszeile 1 ist erforderlich"
      Then I verify "Bundesland" field has error "Bundesland ist erforderlich"
      Then I verify "Postleitzahl" field has error "Postleitzahl ist erforderlich"
      Then I verify "Stadt" field has error "Stadt ist erforderlich"
      When I fill out "E-Mail" field with "aaa"
      Then I verify "E-Mail" field has error "E-Mail Format ist ungültig."
      When I clear "email" field
      And I clear "phone" field
      When I fill out "Name" field with "Los Altos Testing House"
      And I fill out "Kontaktname" field with "Administrator"
      And I fill out "Adresse" field with "4970 El Camino Real"
      And I fill out "Postleitzahl" field with "94022"
      And I fill out "Stadt" field with "Los Altos"
      And I fill out "state" dropdown with "California"
      And I fill out "E-Mail" field with "slava@skryabin.com"
      And I fill out "Telefonnummer" field with "650-215-0000"
      And I submit shipment form
      Then I verify that ship from section contains "Los Altos Testing House"
      Then I verify that ship from section contains "4970 El Camino Real"
      Then I verify that ship from section contains "slava@skryabin.com"
      And I cancel shipment
      Then I verify shipment is cancelled

      @ups4
      Scenario: Verify shipment delivery up to payment
        Given I go to "ups" page
        When I open "Shipping" menu item
        And I open "Create a Shipment:" submenu item
        And I fill out "country" dropdown with "United States"
        And I submit shipment form
        Then I verify "Name" field has error "Name is required"
        Then I verify "Address" field has error "Address Line 1 is required"
        Then I verify "State" field has error "State is required"
        Then I verify "Zip" field has error "ZIP Code is required"
        Then I verify "City" field has error "City is required"
        When I fill out "Email" field with "aaa"
        Then I verify "Email" field has error "Email format is invalid"
        When I clear "email" field
        And I clear "phone" field
        When I fill out "Name" field with "Los Altos Testing House"
        And I fill out "Contact" field with "Administrator"
        And I fill out "Address" field with "4970 El Camino Real"
        And I fill out "ZIP Code" field with "94022"
        And I fill out "City" field with "Los Altos"
        And I fill out "state" dropdown with "California"
        And I fill out "Email" field with "slava@skryabin.com"
        And I fill out "Phone" field with "650-215-0000"
        And I submit shipment form and verify new page opens
        Then I verify that ship from section contains "Los Altos Testing House"
        Then I verify that ship from section contains "4970 El Camino Real"
        Then I verify that ship from section contains "slava@skryabin.com"

        When I fill out "Name" field with "The Permanente Medical Group"
        And I fill out "Contact" field with "William Cappiello"
        And I fill out "Address" field with "710 Lawrence Expressway"
        And I fill out "ZIP Code" field with "95051"
        And I fill out "City" field with "Santa Clara"
        And I fill out "state" dropdown with "California"
        And I fill out "Email" field with "william_cappiello@kp.com"
        And I fill out "Phone" field with "408-851-1850"
        Then I verify total charges "$9.90"
        And I submit shipment form and verify new page opens

        When I fill out Packaging Type dropdown with "UPS Express Box - Small"
        And I fill out package weight field with "1"
        Then I verify total charges "$20.40"
        And I submit shipment form and verify new page opens

        When I select "$20.40" shipment option
        And I submit shipment form and verify new page opens

        And I enable "Saturday Delivery"
        Then I verify total charges "$37.68"
        And I submit shipment form and verify new page opens
        And I verify I'm on "Payment" page
        And I verify "Other Ways to Pay" payment options
        And I verify "PayPal" appears
        And I submit shipment form for review and verify new page opens
        Then I verify that "Ship To" section contains "William Cappiello"
        Then I verify that "Ship To" section contains "710 Lawrence Expressway"
        Then I verify that "Ship From" section contains "94022"
        Then I verify that "Ship From" section contains "Los Altos"
        Then I verify that "Package Information" section contains "UPS Express Box - Small"
        And I cancel shipment
        Then I verify shipment is cancelled


      @ups4
      Scenario: Implement origin to destination
        Given I go to ups shipping page
        When  I fill out ups required fileds
        And  I submit ups form
        Then I verify ups origin fields displayed






