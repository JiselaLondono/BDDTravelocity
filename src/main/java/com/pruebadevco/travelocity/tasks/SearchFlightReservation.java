package com.pruebadevco.travelocity.tasks;

import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.ADD_CAR_CHECKBOX;
import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.ADD_HOTEL_CHECKBOX;
import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.FLIGHT_CLASS_BUTTON;
import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.FLIGHT_CLASS_LIST;
import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.FLIGHT_TYPE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.GOING_TO_BUTTON;
import static com.pruebadevco.travelocity.userinterface.FlightSearchFilters.LEAVING_FROM_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.CHECKIN_DATE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.CHECKOUT_DATE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.END_DATE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.SEARCH_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.START_DATE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebadevco.travelocity.interactions.SearchPlace;
import com.pruebadevco.travelocity.interactions.SelectEndDate;
import com.pruebadevco.travelocity.interactions.SelectStartDate;
import com.pruebadevco.travelocity.models.FlightReservation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class SearchFlightReservation implements Task {

  private FlightReservation flightReservation;

  public SearchFlightReservation(FlightReservation flightReservation) {
    this.flightReservation = flightReservation;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(FLIGHT_TYPE_BUTTON.of(flightReservation.getFlightType())),
        Click.on(LEAVING_FROM_BUTTON),
        SearchPlace.named(flightReservation.getDeparturePlace()),
        Click.on(GOING_TO_BUTTON),
        SearchPlace.named(flightReservation.getDestinationPlace()),
        Click.on(START_DATE_BUTTON),
        SelectStartDate.onTheCalendar(flightReservation.getStartDate()),
        Click.on(END_DATE_BUTTON),
        SelectEndDate.onTheCalendar(
            flightReservation.getEndDate(), flightReservation.getStartDate()),
        Click.on(FLIGHT_CLASS_BUTTON),
        Click.on(FLIGHT_CLASS_LIST.of(flightReservation.getPreferredClass())),
        Check.whether(flightReservation.isAddAHotel())
            .andIfSo(
                Click.on(ADD_HOTEL_CHECKBOX),
                Click.on(CHECKIN_DATE_BUTTON),
                SelectStartDate.onTheCalendar(flightReservation.getCheckInDate()),
                Click.on(CHECKOUT_DATE_BUTTON),
                SelectEndDate.onTheCalendar(
                    flightReservation.getCheckOutDate(), flightReservation.getCheckInDate())),
        Check.whether(flightReservation.isAddACar()).andIfSo(Click.on(ADD_CAR_CHECKBOX)),
        Click.on(SEARCH_BUTTON));
  }

  public static SearchFlightReservation withTheFollowingInformation(
      FlightReservation flightReservation) {
    return instrumented(SearchFlightReservation.class, flightReservation);
  }
}
