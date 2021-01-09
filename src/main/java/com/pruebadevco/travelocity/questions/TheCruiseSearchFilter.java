package com.pruebadevco.travelocity.questions;

import static com.pruebadevco.travelocity.userinterface.CruiseSearchFilters.CRUISES_INFORMATION;

import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class TheCruiseSearchFilter implements Question<Boolean> {
  private String option;

  public TheCruiseSearchFilter(String option) {
    this.option = option;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    List<WebElementFacade> availableCruises =
        CRUISES_INFORMATION
            .resolveAllFor(actor)
            .subList(0, CRUISES_INFORMATION.resolveAllFor(actor).size());
    for (WebElementFacade availableCruise : availableCruises) {
      if (!availableCruise
          .findElement(By.xpath(".//div[@class='title-on-ship-image']"))
          .getText()
          .contains(option)) {
        return false;
      }
    }
    return true;
  }

  public static TheCruiseSearchFilter named(String option) {
    return new TheCruiseSearchFilter(option);
  }

  public TheCruiseSearchFilter wasAppliedInTheCruiseList() {
    return this;
  }
}
