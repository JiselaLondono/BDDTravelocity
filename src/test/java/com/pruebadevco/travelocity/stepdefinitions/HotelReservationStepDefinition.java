package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.utils.Generate.getHotelReservationData;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebadevco.travelocity.models.HotelReservation;
import com.pruebadevco.travelocity.tasks.SearchHotelReservation;
import io.cucumber.java.en.When;
import java.io.IOException;

public class HotelReservationStepDefinition {

  private HotelReservation hotelReservation;

  @When("she searches for the required hotel {string}")
  public void searchReservation(String reservationFeature) throws IOException {
    hotelReservation = getHotelReservationData(reservationFeature);
    theActorInTheSpotlight()
        .attemptsTo(SearchHotelReservation.withTheFollowingInformation(hotelReservation));
  }
}
