package com.pruebadevco.travelocity.questions;

import static com.pruebadevco.travelocity.userinterface.ThingsToDoSearchFilters.FINAL_PRICE_OF_ACTIVITY;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheFinalPriceOfTheActivity implements Question<Integer> {

  @Override
  public Integer answeredBy(Actor actor) {
    return Integer.parseInt(FINAL_PRICE_OF_ACTIVITY.resolveFor(actor).getText().replace("$", ""));
  }

  public static TheFinalPriceOfTheActivity is() {
    return new TheFinalPriceOfTheActivity();
  }
}
