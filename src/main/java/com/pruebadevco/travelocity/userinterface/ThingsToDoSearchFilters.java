package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class ThingsToDoSearchFilters {

  public static final Target DESTINATION_PLACE_BUTTON =
      Target.the("Button that enables list to select destination place")
          .located(By.id("location-field-location-menu"));
  public static final Target FROM_DATE_BUTTON =
      Target.the("Button that enables calendar to select from date")
          .locatedBy("//input[@placeholder='From']/..");
  public static final Target TO_DATE_BUTTON =
      Target.the("Button that enables calendar to select to date")
          .locatedBy("//input[@placeholder='To']/..");
  public static final Target ACTIVITY =
      Target.the("Element that gets the activity information")
          .locatedBy(
              "//h3[@data-testid='activity-spanned-tile-card--title' and text()='{0}']//ancestor::div[@data-testid='activity-spanned-tile-card']");
  public static final Target FINAL_PRICE_OF_ACTIVITY =
      Target.the("Element that gets the activity price")
          .locatedBy(
              "//div[@data-testid='check-availability-button']//span[@class='uitk-lockup-price']");

  public ThingsToDoSearchFilters() {}
}
