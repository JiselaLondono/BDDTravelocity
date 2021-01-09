#Autor: Jisela Londoño Herrera

Feature: Consult hotel information to reserve
  As a user of the Travelocity system
  I want to be able to consult the information of the available hotel
  To be able to make a hotel reservation

  Background:
    Given that Jisela wants to use the "Hotels" reservation service on Travelocity

  Scenario: Hotel available according to search filters
  When she searches for the required hotel "without adding another service"
  Then she should see the hotel "Estelar La Torre Suites" in the list of hotels present to reserve

  @Manual
  Scenario: View information on available rooms
    When she searches for the required hotel "with flight addition"
    And she chooses one of the available hotels
    Then she should see the list of available rooms according to the required information

  @Manual
  Scenario: View available information on departure flights
    When she searches for the required hotel "with flight addition"
    And she chooses one of the available hotels
    And she chooses one of the available rooms
    Then she should see the list of available departure flights according to the search criteria

  @Manual
  Scenario: View available information on destination flights
    When she searches for the required hotel "with flight addition"
    And she chooses one of the available hotels
    And she chooses one of the available rooms
    And she chooses one of the available departure flights
    Then she should see the list of available destination flights according to the search criteria

  @Manual
  Scenario: View information on available cars
    When she searches for the required hotel "with car addition"
    And she chooses one of the available hotels
    And she chooses one of the available rooms
    Then she should see the list of available cars according to the search criteria
