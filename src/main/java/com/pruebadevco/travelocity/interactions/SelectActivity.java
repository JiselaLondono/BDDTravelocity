package com.pruebadevco.travelocity.interactions;

import static com.pruebadevco.travelocity.userinterface.ThingsToDoSearchFilters.ACTIVITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectActivity implements Interaction {
  private String activity;

  public SelectActivity(String activity) {
    this.activity = activity;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(ACTIVITY.of(activity), isEnabled()),
        Click.on(ACTIVITY.of(activity)),
        SwitchToNewWindow.locatedAtPosition(1));
  }

  public static SelectActivity named(String activity) {
    return instrumented(SelectActivity.class, activity);
  }
}
