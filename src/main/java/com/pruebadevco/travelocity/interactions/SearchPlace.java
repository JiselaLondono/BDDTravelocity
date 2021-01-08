package com.pruebadevco.travelocity.interactions;

import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.PLACE_SEARCH_LIST;
import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.PLACE_SEARCH_TEXT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchPlace implements Interaction {

  private String placeName;

  public SearchPlace(String placeName) {
    this.placeName = placeName;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(PLACE_SEARCH_TEXT, isVisible()),
        Enter.theValue(placeName).into(PLACE_SEARCH_TEXT),
        Click.on(PLACE_SEARCH_LIST.of(placeName)));
  }

  public static SearchPlace named(String placeName) {
    return instrumented(SearchPlace.class, placeName);
  }
}
