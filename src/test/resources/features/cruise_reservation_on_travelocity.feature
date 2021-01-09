#Autor: Jisela Londoño Herrera

Feature: Consult cruise information to reserve
  As a user of the Travelocity system
  I want to be able to consult the information of the available cruise
  To be able to make a cruise reservation

  Background:
    Given that Jisela wants to use the "Cruises" reservation service on Travelocity

  Scenario: Cruises available according to search filters
    When she searches for the required cruise "to Africa"
    Then she should see that the cruise list was filtered with the option "Africa"

  @Manual
  Scenario: View information of cabin experience for the reservation
    When she searches for the required cruise "to Bahamas"
    And she chooses one of the available cruises
    Then she should see the detailed listing of the available cabin experience

  @Manual
  Scenario: View information of cabin type for the reservation
    When she searches for the required cruise "to Bahamas"
    And she chooses one of the available cruises
    And she chooses one of the cabin experience
    Then she should see the detailed listing of the available cabin type

  @Manual
  Scenario: View information of rate for the reservation
    When she searches for the required cruise "to Bahamas"
    And she chooses one of the available cruises
    And she chooses one of the cabin experience
    And she chooses one of the cabin type
    Then she should see the rate detail

  @Manual
  Scenario: View information of cabin number for the reservation
    When she searches for the required cruise "to Bahamas"
    And she chooses one of the available cruises
    And she chooses one of the cabin experience
    And she chooses one of the cabin type
    And she chooses one of the rates
    Then she should see the information of cabin numbers availables for the reservation