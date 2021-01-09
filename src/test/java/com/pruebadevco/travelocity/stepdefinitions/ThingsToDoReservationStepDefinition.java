package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.utils.Generate.getThingsToDoReservationData;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.DIFFERENT_VALUE_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.pruebadevco.travelocity.exceptions.DifferentValueException;
import com.pruebadevco.travelocity.interactions.SelectActivity;
import com.pruebadevco.travelocity.models.ThingsToDoReservation;
import com.pruebadevco.travelocity.questions.TheFinalPriceOfTheActivity;
import com.pruebadevco.travelocity.tasks.SearchThingsToDoReservation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class ThingsToDoReservationStepDefinition {
  private ThingsToDoReservation thingsToDoReservation;

  @When("she searches for the required things to do {string}")
  public void searchReservation(String reservationFeature) throws IOException {
    thingsToDoReservation = getThingsToDoReservationData(reservationFeature);
    theActorInTheSpotlight()
        .attemptsTo(SearchThingsToDoReservation.withTheFollowingInformation(thingsToDoReservation));
  }

  @When("she selects the {string} activity")
  public void selectActivity(String activity) {
    theActorInTheSpotlight().attemptsTo(SelectActivity.named(activity));
  }

  @Then("she should see that the price of the selected activity is {int}")
  public void validatePriceOfActivity(int priceOfActivity) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheFinalPriceOfTheActivity.is(), equalTo(priceOfActivity))
                .orComplainWith(DifferentValueException.class, DIFFERENT_VALUE_ERROR.getMessage()));
  }
}
