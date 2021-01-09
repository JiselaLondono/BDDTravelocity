package com.pruebadevco.travelocity.tasks;

import static com.pruebadevco.travelocity.userinterface.GeneralFilters.SEARCH_BUTTON;
import static com.pruebadevco.travelocity.userinterface.ThingsToDoSearchFilters.DESTINATION_PLACE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.ThingsToDoSearchFilters.FROM_DATE_BUTTON;
import static com.pruebadevco.travelocity.userinterface.ThingsToDoSearchFilters.TO_DATE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebadevco.travelocity.interactions.SearchPlace;
import com.pruebadevco.travelocity.interactions.SelectEndDate;
import com.pruebadevco.travelocity.interactions.SelectStartDate;
import com.pruebadevco.travelocity.models.ThingsToDoReservation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SearchThingsToDoReservation implements Task {
  private ThingsToDoReservation thingsToDoReservation;

  public SearchThingsToDoReservation(ThingsToDoReservation thingsToDoReservation) {
    this.thingsToDoReservation = thingsToDoReservation;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(DESTINATION_PLACE_BUTTON),
        SearchPlace.named(thingsToDoReservation.getDestinationPlace()),
        Click.on(FROM_DATE_BUTTON),
        SelectStartDate.onTheCalendar(thingsToDoReservation.getStartDate()),
        Click.on(TO_DATE_BUTTON),
        SelectEndDate.onTheCalendar(
            thingsToDoReservation.getEndDate(), thingsToDoReservation.getStartDate()),
        Click.on(SEARCH_BUTTON));
  }

  public static SearchThingsToDoReservation withTheFollowingInformation(
      ThingsToDoReservation thingsToDoReservation) {
    return instrumented(SearchThingsToDoReservation.class, thingsToDoReservation);
  }
}
