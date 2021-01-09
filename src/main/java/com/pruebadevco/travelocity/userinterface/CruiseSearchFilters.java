package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CruiseSearchFilters {
  public static final Target CRUISE_DESTINATION =
      Target.the("Cruise destination list").located(By.id("cruise-destination"));
  public static final Target DEPARTS_AS_EARLY_AS_BUTTON =
      Target.the("From date button").locatedBy("//input[@placeholder='Departs as early as']/..");
  public static final Target DEPARTS_AS_LATE_AS_BUTTON =
      Target.the("To date button").locatedBy("//input[@placeholder='Departs as late as']/..");
  public static final Target CRUISES_INFORMATION =
      Target.the("Cruises information")
          .locatedBy("//section[@class='col search-results']//div[@class='flex-card']");
}
