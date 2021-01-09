package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class CruiseSearchFilters {

  public static final Target CRUISE_DESTINATION =
      Target.the("Cruise destination list").located(By.id("cruise-destination"));
  public static final Target DEPARTS_AS_EARLY_AS_BUTTON =
      Target.the("Button that enables calendar to select departs as early as date")
          .locatedBy("//input[@placeholder='Departs as early as']/..");
  public static final Target DEPARTS_AS_LATE_AS_BUTTON =
      Target.the("Button that enables calendar to select departs as late as date")
          .locatedBy("//input[@placeholder='Departs as late as']/..");
  public static final Target CRUISES_INFORMATION =
      Target.the("Element containing the cruise information")
          .locatedBy("//section[@class='col search-results']//div[@class='flex-card']");

  public CruiseSearchFilters() {}
}
