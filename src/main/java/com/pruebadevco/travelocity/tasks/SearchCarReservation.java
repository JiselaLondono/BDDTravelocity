package com.pruebadevco.travelocity.tasks;

import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.AARP_RATE_CHECKBOX;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.AIRPORT_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.BOOK_ROUNDTRIP_CHECKBOX;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.CAR_SERVICE_TYPE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.DISCOUNT_CODE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.DISCOUNT_TYPE_LIST;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.DROP_OF_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.DROP_OF_TIME_LIST;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.FLIGHT_ARRIVAL_TIME_LIST;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.FLIGHT_DEPARTURE_TIME_LIST;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.HOTEL_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.PICK_UP_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.PICK_UP_TIME_LIST;
import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.PREFERRED_BRAND_LIST;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.END_DATE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.SEARCH_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.START_DATE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebadevco.travelocity.interactions.SearchPlace;
import com.pruebadevco.travelocity.interactions.SelectEndDate;
import com.pruebadevco.travelocity.interactions.SelectStartDate;
import com.pruebadevco.travelocity.models.CarReservation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;

public class SearchCarReservation implements Task {

  private CarReservation carReservation;
  private static final String RENTAL_CARS_SERVICE = "Rental cars";

  public SearchCarReservation(CarReservation carReservation) {
    this.carReservation = carReservation;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(CAR_SERVICE_TYPE_BUTTON.of(carReservation.getCarServiceType())),
        Check.whether(carReservation.getCarServiceType().equals(RENTAL_CARS_SERVICE))
            .andIfSo(
                Click.on(PICK_UP_BUTTON),
                SearchPlace.named(carReservation.getDeparturePlace()),
                Click.on(DROP_OF_BUTTON),
                SearchPlace.named(carReservation.getDestinationPlace()),
                Click.on(START_DATE_BUTTON),
                SelectStartDate.onTheCalendar(carReservation.getStartDate()),
                Click.on(END_DATE_BUTTON),
                SelectEndDate.onTheCalendar(
                    carReservation.getEndDate(), carReservation.getStartDate()),
                SelectFromOptions.byVisibleText(carReservation.getStartTime())
                    .from(PICK_UP_TIME_LIST),
                SelectFromOptions.byVisibleText(carReservation.getEndTime())
                    .from(DROP_OF_TIME_LIST),
                Check.whether(carReservation.isAarpMemberRateIncluded())
                    .andIfSo(Click.on(AARP_RATE_CHECKBOX)),
                Check.whether(carReservation.isHaveDiscountCode())
                    .andIfSo(
                        Click.on(DISCOUNT_CODE_BUTTON),
                        SelectFromOptions.byVisibleText(carReservation.getPreferredBrand())
                            .from(PREFERRED_BRAND_LIST),
                        SelectFromOptions.byVisibleText(carReservation.getDiscountType())
                            .from(DISCOUNT_TYPE_LIST)))
            .otherwise(
                Click.on(AIRPORT_BUTTON),
                SearchPlace.named(carReservation.getDeparturePlace()),
                Click.on(HOTEL_BUTTON),
                SearchPlace.named(carReservation.getDestinationPlace()),
                Click.on(START_DATE_BUTTON),
                SelectStartDate.onTheCalendar(carReservation.getStartDate()),
                SelectFromOptions.byVisibleText(carReservation.getStartTime())
                    .from(FLIGHT_ARRIVAL_TIME_LIST),
                Check.whether(carReservation.isBookRoundtrip())
                    .andIfSo(
                        Click.on(BOOK_ROUNDTRIP_CHECKBOX),
                        Click.on(END_DATE_BUTTON),
                        SelectEndDate.onTheCalendar(
                            carReservation.getEndDate(), carReservation.getStartDate()),
                        SelectFromOptions.byVisibleText(carReservation.getEndTime())
                            .from(FLIGHT_DEPARTURE_TIME_LIST))),
        Click.on(SEARCH_BUTTON));
  }

  public static SearchCarReservation withTheFollowingInformation(CarReservation carReservation) {
    return instrumented(SearchCarReservation.class, carReservation);
  }
}
