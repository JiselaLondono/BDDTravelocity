package com.pruebadevco.travelocity.tasks;

import static com.pruebadevco.travelocity.userinterface.CruiseSearchFilters.CRUISE_DESTINATION;
import static com.pruebadevco.travelocity.userinterface.CruiseSearchFilters.DEPARTS_AS_EARLY_AS_BUTTON;
import static com.pruebadevco.travelocity.userinterface.CruiseSearchFilters.DEPARTS_AS_LATE_AS_BUTTON;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebadevco.travelocity.interactions.SelectStartDate;
import com.pruebadevco.travelocity.models.CruiseReservation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SearchCruiseReservation implements Task {

  private CruiseReservation cruiseReservation;

  public SearchCruiseReservation(CruiseReservation cruiseReservation) {
    this.cruiseReservation = cruiseReservation;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectFromOptions.byVisibleText(cruiseReservation.getDestinationPlace())
            .from(CRUISE_DESTINATION),
        Click.on(DEPARTS_AS_EARLY_AS_BUTTON),
        SelectStartDate.onTheCalendar(cruiseReservation.getStartDate()),
        Click.on(DEPARTS_AS_LATE_AS_BUTTON),
        SelectStartDate.onTheCalendar(cruiseReservation.getEndDate()),
        Click.on(SEARCH_BUTTON));
  }

  public static SearchCruiseReservation withTheFollowingInformation(
      CruiseReservation cruiseReservation) {
    return instrumented(SearchCruiseReservation.class, cruiseReservation);
  }
}
