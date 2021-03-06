package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class HotelInformation {

  public static final Target HOTEL_NAME =
      Target.the("Element that gets the name of the hotel")
          .locatedBy(
              "//section[@class='results']//li//h3[@data-stid='content-hotel-title' and text()='{0}']");

  private HotelInformation() {}
}
