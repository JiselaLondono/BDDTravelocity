package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class CarInformation {

  public static final Target CAR_NOT_FOUND_TEXT =
      Target.the("Label where the messages are presented")
          .locatedBy("//div[@class='uitk-empty-state-heading']");
  public static final Target AVAILABLE_CARS =
      Target.the("Container cars available").locatedBy("//div[@class='offer-card-desktop']");

  public CarInformation() {}
}
