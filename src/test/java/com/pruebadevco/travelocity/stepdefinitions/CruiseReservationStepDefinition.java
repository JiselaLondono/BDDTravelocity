package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.utils.Generate.getCruiseReservationData;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.SEARCH_FILTER_NOT_APPLIED_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebadevco.travelocity.exceptions.SearchFilterNotAppliedException;
import com.pruebadevco.travelocity.models.CruiseReservation;
import com.pruebadevco.travelocity.questions.TheCruiseSearchFilter;
import com.pruebadevco.travelocity.tasks.SearchCruiseReservation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class CruiseReservationStepDefinition {
  private CruiseReservation cruiseReservation;

  @When("she searches for the required cruise {string}")
  public void searchCruiseReservation(String reservationFeature) throws IOException {
    cruiseReservation = getCruiseReservationData(reservationFeature);
    theActorInTheSpotlight()
        .attemptsTo(SearchCruiseReservation.withTheFollowingInformation(cruiseReservation));
  }

  @Then("she should see that the cruise list was filtered with the option {string}")
  public void validateCruiseSearchFilter(String option) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheCruiseSearchFilter.named(option).wasAppliedInTheCruiseList())
                .orComplainWith(
                    SearchFilterNotAppliedException.class,
                    String.format(SEARCH_FILTER_NOT_APPLIED_ERROR.getMessage(), option)));
  }
}
