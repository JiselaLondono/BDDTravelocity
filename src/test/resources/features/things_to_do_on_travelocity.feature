#Autor: Jisela Londoño Herrera

Feature: Consult Things to do information to reserve
  As a user of the Travelocity system
  I want to be able to consult the information of the available Things to do
  To be able to make a Things to do reservation

  Background:
    Given that Jisela wants to use the "Things to do" reservation service on Travelocity

  @Manual
  Scenario: Activities available according to search filters
    When she searches for the required things to do "in Medellin"
    And she filters available activities by: "Interests", "History & culture"
    Then she should see that the activity list was filtered with the option "History & culture"


  Scenario: View information of the activity selected for the reservation with price validation
    When she searches for the required things to do "in Medellin"
    And she selects the "Journey of flavors around Colombia" activity
    Then she should see that the price of the selected activity is 99