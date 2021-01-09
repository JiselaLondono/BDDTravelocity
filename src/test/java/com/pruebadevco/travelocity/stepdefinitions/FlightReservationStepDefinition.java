package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.utils.Generate.getFlightReservationData;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.SEARCH_FILTER_NOT_APPLIED_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebadevco.travelocity.exceptions.SearchFilterNotAppliedException;
import com.pruebadevco.travelocity.interactions.SelectFlightFilter;
import com.pruebadevco.travelocity.models.FlightReservation;
import com.pruebadevco.travelocity.questions.TheSearchFilter;
import com.pruebadevco.travelocity.tasks.SearchFlightReservation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class FlightReservationStepDefinition {

  private FlightReservation flightReservation;

  @When("she searches for the required flight {string}")
  public void searchFlightReservation(String reservationFeature) throws IOException {
    flightReservation = getFlightReservationData(reservationFeature);
    theActorInTheSpotlight()
        .attemptsTo(SearchFlightReservation.withTheFollowingInformation(flightReservation));
  }

  @When("she filters available flights by: {string}, {string}")
  public void selectFlightFilter(String filterCategory, String option) {
    theActorInTheSpotlight()
        .attemptsTo(SelectFlightFilter.withTheFollowingInformation(filterCategory, option));
  }

  @Then("she should see that the flight list was filtered with the option {string}")
  public void validateSearchFilter(String option) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheSearchFilter.named(option).wasAppliedInTheFlightList())
                .orComplainWith(
                    SearchFilterNotAppliedException.class,
                    String.format(SEARCH_FILTER_NOT_APPLIED_ERROR.getMessage(), option)));
  }
}
