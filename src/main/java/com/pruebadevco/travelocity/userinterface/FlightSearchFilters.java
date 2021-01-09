package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightSearchFilters {
  public static final Target TYPE_FLIGHT_BUTTON =
      Target.the("").locatedBy("//div[@class='uitk-tabs-inner-container']//span[text()='{0}']");
  public static final Target LEAVING_FROM_BUTTON =
      Target.the("").located(By.id("location-field-leg1-origin-menu"));
  public static final Target GOING_TO_BUTTON =
      Target.the("").located(By.id("location-field-leg1-destination-menu"));
  public static final Target FLIGHT_CLASS_BUTTON =
      Target.the("").located(By.id("preferred-class-input"));
  public static final Target FLIGHT_CLASS_LIST =
      Target.the("").locatedBy("//div[@id='preferred-class-input']//div//a[text()='{0}']");
  public static final Target ADD_HOTEL_CHECKBOX =
      Target.the("").located(By.id("add-hotel-checkbox"));
  public static final Target ADD_CAR_CHECKBOX = Target.the("").located(By.id("add-car-checkbox"));
  public static final Target FLIGHT_FILTER =
      Target.the("")
          .locatedBy(
              "//div[@id='filter-container']//legend[contains(text(), '{0}')]//ancestor::fieldset//div[@class='check filter-option']//span[@class='inline-label' and contains(text(), '{1}')]/../input");
}
