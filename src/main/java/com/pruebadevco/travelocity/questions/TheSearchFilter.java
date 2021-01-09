package com.pruebadevco.travelocity.questions;

import static com.pruebadevco.travelocity.userinterface.FlightInformation.AVAILABLE_FLIGHTS;

import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class TheSearchFilter implements Question<Boolean> {
  private String option;

  public TheSearchFilter(String option) {
    this.option = option;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    List<WebElementFacade> availableFlights =
        AVAILABLE_FLIGHTS
            .resolveAllFor(actor)
            .subList(0, AVAILABLE_FLIGHTS.resolveAllFor(actor).size());

    for (WebElementFacade availableFlight : availableFlights) {
      if (!option.equals(
          availableFlight
              .findElement(By.xpath(".//span[@data-test-id='airline-name']"))
              .getText())) {
        return false;
      }
    }

    return true;
  }

  public static TheSearchFilter named(String option) {
    return new TheSearchFilter(option);
  }

  public TheSearchFilter wasAppliedInTheFlightList() {
    return this;
  }
}
