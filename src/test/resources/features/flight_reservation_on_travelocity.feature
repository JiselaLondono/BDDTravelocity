#Autor: Jisela Londoño Herrera

Feature: Consult flight information to reserve
  As a user of the Travelocity system
  I want to be able to consult the information of the available flight
  To be able to make a flight reservation

  Background:
    Given that Jisela wants to use the "Flights" reservation service on Travelocity

  Scenario: Flights available according to search filters
    When she searches for the required flight "Roundtrip"
    And she filters available flights by: "Airlines included", "Avianca"
    Then she should see that the flight list was filtered with the option "Avianca"

  @Manual
  Scenario: View information on available hotels
    When she searches for the required flight "with Add a place to stay"
    Then she should see the list of available hotels according to the required information

  @Manual
  Scenario: View information on available rooms
    When she searches for the required flight "with Add a place to stay"
    And she chooses one of the available hotels
    Then she should see the list of available rooms according to the required information

  @Manual
  Scenario: View available information on departure flights
    When she searches for the required flight "with Add a place to stay"
    And she chooses one of the available hotels
    And she chooses one of the available rooms
    Then she should see the list of available departure flights according to the search criteria

  @Manual
  Scenario: View available information on destination flights
    When she searches for the required flight "with Add a place to stay"
    And she chooses one of the available hotels
    And she chooses one of the available rooms
    And she chooses one of the available departure flights
    Then she should see the list of available destination flights according to the search criteria

