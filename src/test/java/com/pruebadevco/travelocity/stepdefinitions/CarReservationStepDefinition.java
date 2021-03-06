package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.userinterface.CarInformation.CAR_NOT_FOUND_TEXT;
import static com.pruebadevco.travelocity.utils.Generate.getCarReservationData;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.MESSAGE_EXPECTED_ERROR;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.SEARCH_FILTER_NOT_APPLIED_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import com.pruebadevco.travelocity.exceptions.InvalidMessageException;
import com.pruebadevco.travelocity.exceptions.SearchFilterNotAppliedException;
import com.pruebadevco.travelocity.interactions.SelectCarFilter;
import com.pruebadevco.travelocity.models.CarReservation;
import com.pruebadevco.travelocity.questions.TheSelectedCarFilter;
import com.pruebadevco.travelocity.questions.TheText;
import com.pruebadevco.travelocity.tasks.SearchCarReservation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class CarReservationStepDefinition {

  private CarReservation carReservation;

  @When("she is looking for a car required {string}")
  public void searchCarReservation(String reservationFeature) throws IOException {
    carReservation = getCarReservationData(reservationFeature);
    theActorInTheSpotlight()
        .attemptsTo(SearchCarReservation.withTheFollowingInformation(carReservation));
  }

  @When("she filters available cars by: {string}, {string}")
  public void selectCarFilter(String filterCategory, String option) {
    theActorInTheSpotlight()
        .attemptsTo(SelectCarFilter.withTheFollowingInformation(filterCategory, option));
  }

  @Then("she should see the following message: {string}")
  public void validateCarNotAvailable(String message) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheText.of(CAR_NOT_FOUND_TEXT), is(containsString(message)))
                .orComplainWith(
                    InvalidMessageException.class,
                    String.format(MESSAGE_EXPECTED_ERROR.getMessage(), message)));
  }

  @Then("she should see that the car list was filtered with the option {string}")
  public void validateCarSearchFilter(String filterOption) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheSelectedCarFilter.named(filterOption).wasAppliedInTheCarList())
                .orComplainWith(
                    SearchFilterNotAppliedException.class,
                    String.format(SEARCH_FILTER_NOT_APPLIED_ERROR.getMessage(), filterOption)));
  }
}
