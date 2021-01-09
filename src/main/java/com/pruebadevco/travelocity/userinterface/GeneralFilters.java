package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GeneralFilters {
  public static final Target PLACE_SEARCH_TEXT =
      Target.the("")
          .locatedBy(
              "//div[@class='uitk-menu-container elevation-8 uitk-menu-open uitk-menu-pos-left']//input");
  public static final Target PLACE_SEARCH_LIST =
      Target.the("")
          .locatedBy(
              "//div[@class='uitk-menu-container elevation-8 uitk-menu-open uitk-menu-pos-left']//li//strong[text()='{0}']//ancestor::button");
  public static final Target START_DATE_BUTTON = Target.the("").located(By.id("d1-btn"));
  public static final Target END_DATE_BUTTON = Target.the("").located(By.id("d2-btn"));
  public static final Target CHECKIN_DATE_BUTTON =
      Target.the("").locatedBy("//input[@placeholder='Check-in']/..");
  public static final Target CHECKOUT_DATE_BUTTON =
      Target.the("").locatedBy("//input[@placeholder='Check-out']/..");
  public static final Target CALENDAR_MONTH =
      Target.the("").locatedBy("//div[@class='uitk-new-date-picker-month'][1]/h2");
  public static final Target DATE_SELECT =
      Target.the("Button to select date")
          .locatedBy("//div[@class='uitk-new-date-picker-month'][1]//td/button[@data-day='{0}']");
  public static final Target NEXT_MONTH =
      Target.the("").locatedBy("//div[@class='uitk-calendar']//button[2]");
  public static final Target APPLY_DATE_BUTTON =
      Target.the("").locatedBy("//button[@data-stid='apply-date-picker']/span");
  public static final Target SEARCH_BUTTON =
      Target.the("").locatedBy("//button[@data-testid='submit-button' and text()='Search']");
}
