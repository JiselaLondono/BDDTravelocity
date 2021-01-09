Feature: Reservacion vuelo
  As
  I
  To

  Scenario: Prueba1
    Given that Jisela wants to use the Flights reservation service on Travelocity
    When she searches for the required flight "prueba"
    And she filters available flights by: "Airlines included", "Avianca"
    Then she should see that the flight list was filtered with the option "Avianca"