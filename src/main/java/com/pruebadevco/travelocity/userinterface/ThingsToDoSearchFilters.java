package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ThingsToDoSearchFilters {
  public static final Target DESTINATION_PLACE_BUTTON =
      Target.the("Destination button").located(By.id("location-field-location-menu"));
  public static final Target FROM_DATE_BUTTON =
      Target.the("From date button").locatedBy("//input[@placeholder='From']/..");
  public static final Target TO_DATE_BUTTON =
      Target.the("To date button").locatedBy("//input[@placeholder='To']/..");
  public static final Target ACTIVITY =
      Target.the("Activity to do")
          .locatedBy(
              "//h3[@data-testid='activity-spanned-tile-card--title' and text()='{0}']//ancestor::div[@data-testid='activity-spanned-tile-card']");
  public static final Target FINAL_PRICE_OF_ACTIVITY =
      Target.the("Final price of activity")
          .locatedBy(
              "//div[@data-testid='check-availability-button']//span[@class='uitk-lockup-price']");
}
