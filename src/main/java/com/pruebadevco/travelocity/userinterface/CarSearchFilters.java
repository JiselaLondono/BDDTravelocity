package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarSearchFilters {
  public static final Target CAR_SERVICE_TYPE_BUTTON =
      Target.the("").locatedBy("//div[@class='uitk-tabs-inner-container']//span[text()='{0}']");
  public static final Target PICK_UP_BUTTON =
      Target.the("").located(By.id("location-field-locn-menu"));
  public static final Target DROP_OF_BUTTON =
      Target.the("").located(By.id("location-field-loc2-menu"));
  public static final Target AIRPORT_BUTTON =
      Target.the("").located(By.id("location-field-location-menu"));
  public static final Target HOTEL_BUTTON =
      Target.the("").located(By.id("location-field-hotelName-menu"));
  public static final Target PICK_UP_TIME_LIST =
      Target.the("").locatedBy("//select[@aria-label='Pick-up time']");
  public static final Target DROP_OF_TIME_LIST =
      Target.the("").locatedBy("//select[@aria-label='Drop-off time']");
  public static final Target FLIGHT_ARRIVAL_TIME_LIST =
      Target.the("").locatedBy("//select[@aria-label='Flight arrival time']");
  public static final Target FLIGHT_DEPARTURE_TIME_LIST =
      Target.the("").locatedBy("//select[@aria-label='Flight departure time']");
  public static final Target AARP_RATE_CHECKBOX =
      Target.the("").located(By.id("aarp-checkbox-toggle"));
  public static final Target BOOK_ROUNDTRIP_CHECKBOX =
      Target.the("").located(By.id("book-roundtrip-toggle"));
  public static final Target DISCOUNT_CODE_BUTTON =
      Target.the("").locatedBy("//span[@aria-hidden='true' and text()='I have a discount code']");
  public static final Target PREFERRED_BRAND_LIST =
      Target.the("").locatedBy("//select[@aria-label='Preferred brand']");
  public static final Target DISCOUNT_TYPE_LIST =
      Target.the("").locatedBy("//select[@aria-label='Discount type']");
  public static final Target CAR_FILTER =
      Target.the("")
          .locatedBy(
              "//div[@class='s-x-padding-one']//legend[contains(text(), '{0}')]/..//div//input[@type='checkbox']/..//span[contains(text(), '{1}')]");
}
