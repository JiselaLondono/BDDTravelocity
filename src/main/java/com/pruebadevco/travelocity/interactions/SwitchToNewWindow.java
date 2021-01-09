package com.pruebadevco.travelocity.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Set;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;

public class SwitchToNewWindow implements Interaction {
  private int position;

  public SwitchToNewWindow(int position) {
    this.position = position;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Set<String> a = BrowseTheWeb.as(actor).getDriver().getWindowHandles();

    actor.attemptsTo(Switch.toWindow(a.toArray()[position].toString()));
  }

  public static SwitchToNewWindow locatedAtPosition(int position) {
    return instrumented(SwitchToNewWindow.class, position);
  }
}
