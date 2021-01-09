package com.pruebadevco.travelocity.interactions;

import static com.pruebadevco.travelocity.userinterface.CarSearchFilters.CAR_FILTER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectCarFilter implements Interaction {

  private String filterCategory;
  private String option;

  public SelectCarFilter(String filterCategory, String option) {
    this.filterCategory = filterCategory;
    this.option = option;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(CAR_FILTER.of(filterCategory, option), isEnabled()),
        Click.on(CAR_FILTER.of(filterCategory, option)));
  }

  public static SelectCarFilter withTheFollowingInformation(String filterCategory, String option) {
    return instrumented(SelectCarFilter.class, filterCategory, option);
  }
}
