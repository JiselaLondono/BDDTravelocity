Feature: Reservacion carro
  As
  I
  To

  Scenario: Cars available according to search filters
    Given that Jisela wants to use the "Cars" reservation service on Travelocity
    When she is looking for a car required "for rent it"
    And she filters available cars by: "Car type", "Mini"
    Then she should see that the car list was filtered with the option "Mini"

    @Manual
  Scenario: Cars not available according to search filters
    Given that Jisela wants to use the "Cars" reservation service on Travelocity
    When she is looking for a car required "for airport transportation"
    Then she should see the following message: "Sorry, we couldn’t find any airport transportation"