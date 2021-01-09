package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class GeneralFilters {

  public static final Target PLACE_SEARCH_TEXT =
      Target.the("Text field to enter place")
          .locatedBy(
              "//div[@class='uitk-menu-container elevation-8 uitk-menu-open uitk-menu-pos-left']//input");
  public static final Target PLACE_SEARCH_LIST =
      Target.the("List of the different places")
          .locatedBy(
              "//div[@class='uitk-menu-container elevation-8 uitk-menu-open uitk-menu-pos-left']//li//strong[text()='{0}']//ancestor::button");
  public static final Target START_DATE_BUTTON =
      Target.the("Button that enables calendar to select start date").located(By.id("d1-btn"));
  public static final Target END_DATE_BUTTON =
      Target.the("Button that enables calendar to select end date").located(By.id("d2-btn"));
  public static final Target CHECKIN_DATE_BUTTON =
      Target.the("Button that enables calendar to select check-in date")
          .locatedBy("//input[@placeholder='Check-in']/..");
  public static final Target CHECKOUT_DATE_BUTTON =
      Target.the("Button that enables calendar to select check-out date")
          .locatedBy("//input[@placeholder='Check-out']/..");
  public static final Target CALENDAR_MONTH =
      Target.the("Element that gets the month in the calendar")
          .locatedBy("//div[@class='uitk-new-date-picker-month'][1]/h2");
  public static final Target DATE_SELECT =
      Target.the("Button to select date")
          .locatedBy("//div[@class='uitk-new-date-picker-month'][1]//td/button[@data-day='{0}']");
  public static final Target NEXT_MONTH =
      Target.the("Button to select next month")
          .locatedBy("//div[@class='uitk-calendar']//button[2]");
  public static final Target APPLY_DATE_BUTTON =
      Target.the("Button to apply the selected date")
          .locatedBy("//button[@data-stid='apply-date-picker']/span");
  public static final Target SEARCH_BUTTON =
      Target.the("Button to search for information")
          .locatedBy("//button[@data-testid='submit-button' and text()='Search']");

  public GeneralFilters() {}
}
