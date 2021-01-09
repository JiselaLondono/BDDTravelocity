package com.pruebadevco.travelocity.questions;

import static com.pruebadevco.travelocity.userinterface.CarInformation.AVAILABLE_CARS;

import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class TheSelectedCarFilter implements Question<Boolean> {

  private String option;

  public TheSelectedCarFilter(String option) {
    this.option = option;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    List<WebElementFacade> availableCars =
        AVAILABLE_CARS.resolveAllFor(actor).subList(0, AVAILABLE_CARS.resolveAllFor(actor).size());
    for (WebElementFacade availableCar : availableCars) {
      if (!option.equals(
          availableCar.findElement(By.xpath(".//h3[@class='uitk-type-heading-500']")).getText())) {
        return false;
      }
    }
    return true;
  }

  public static TheSelectedCarFilter named(String option) {
    return new TheSelectedCarFilter(option);
  }

  public TheSelectedCarFilter wasAppliedInTheCarList() {
    return this;
  }
}
