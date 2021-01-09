#Autor: Jisela Londoño Herrera

Feature: Consult car information to reserve
  As a user of the Travelocity system
  I want to be able to consult the information of the available cars
  To be able to make a car reservation

  Background:
    Given that Jisela wants to use the "Cars" reservation service on Travelocity

  Scenario: Cars available according to search filters
    When she is looking for a car required "for rent it"
    And she filters available cars by: "Car type", "Mini"
    Then she should see that the car list was filtered with the option "Mini"

  @Manual
  Scenario: Cars not available according to search filters
    When she is looking for a car required "for airport transportation"
    Then she should see the following message: "Sorry, we couldn’t find any airport transportation"

  @Manual
  Scenario: Enter filters required for car search
    When she is looking for a car required "without entering the required information"
    Then she should see the following message: "To continue, please correct the error below."

  @Manual
  Scenario: View information of the car selected for the reservation
    When she is looking for a car required "with discount code"
    And she filters available cars by: "Car type", "Economy"
    And she chooses one of the available cars
    Then she should see the detailed information of the chosen car