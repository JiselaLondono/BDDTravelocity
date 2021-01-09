package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.utils.Generate.getHotelReservationData;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.HOTEL_NOT_FOUND_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebadevco.travelocity.exceptions.HotelNotFoundException;
import com.pruebadevco.travelocity.models.HotelReservation;
import com.pruebadevco.travelocity.questions.InTheHotelsDisplayed;
import com.pruebadevco.travelocity.tasks.SearchHotelReservation;
import io.cucumber.java.en.Then;
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

  @Then("she should see the hotel {string} in the list of hotels present to reserve")
  public void validateHotelList(String hotelName) {
    theActorInTheSpotlight()
        .should(
            seeThat(InTheHotelsDisplayed.theHotel(hotelName))
                .orComplainWith(
                    HotelNotFoundException.class,
                    String.format(HOTEL_NOT_FOUND_ERROR.getMessage(), hotelName)));
  }
}
