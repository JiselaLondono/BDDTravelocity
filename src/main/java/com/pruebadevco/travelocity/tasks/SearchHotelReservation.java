package com.pruebadevco.travelocity.tasks;

import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.ADD_CAR_CHECKBOX;
import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.ADD_FLIGHT_CHECKBOX;
import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.DEPARTURE_PLACE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.DESTINATION_PLACE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebadevco.travelocity.interactions.SearchPlace;
import com.pruebadevco.travelocity.interactions.SelectEndDate;
import com.pruebadevco.travelocity.interactions.SelectStartDate;
import com.pruebadevco.travelocity.models.HotelReservation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class SearchHotelReservation implements Task {

  private HotelReservation hotelReservation;

  public SearchHotelReservation(HotelReservation hotelReservation) {
    this.hotelReservation = hotelReservation;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(DESTINATION_PLACE_BUTTON),
        SearchPlace.named(hotelReservation.getDestinationPlace()),
        SelectStartDate.onTheCalendar(hotelReservation.getCheckInDate()),
        SelectEndDate.onTheCalendar(
            hotelReservation.getCheckOutDate(), hotelReservation.getCheckInDate()),
        Check.whether(hotelReservation.isAddAFlight())
            .andIfSo(
                Click.on(ADD_FLIGHT_CHECKBOX),
                Click.on(DEPARTURE_PLACE_BUTTON),
                SearchPlace.named(hotelReservation.getDeparturePlace())),
        Check.whether(hotelReservation.isAddACar()).andIfSo(Click.on(ADD_CAR_CHECKBOX)));
  }

  public static SearchHotelReservation withTheFollowingInformation(
      HotelReservation hotelReservation) {
    return instrumented(SearchHotelReservation.class, hotelReservation);
  }
}
