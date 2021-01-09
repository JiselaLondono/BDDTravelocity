package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class HotelSearchFilters {

  public static final Target DESTINATION_PLACE_BUTTON =
      Target.the("Button that enables list to select destination place")
          .located(By.id("location-field-destination-menu"));
  public static final Target ADD_FLIGHT_CHECKBOX =
      Target.the("Check box to select add flight").located(By.id("add-flight-switch"));
  public static final Target ADD_CAR_CHECKBOX =
      Target.the("Check box to select add car").located(By.id("add-car-switch"));
  public static final Target DEPARTURE_PLACE_BUTTON =
      Target.the("Button that enables list to select departure place")
          .located(By.id("location-field-origin-menu"));

  public HotelSearchFilters() {}
}
