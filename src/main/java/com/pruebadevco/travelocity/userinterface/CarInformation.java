package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class CarInformation {

  public static final Target CAR_NOT_FOUND_TEXT =
      Target.the("").locatedBy("//div[@class='uitk-empty-state-heading']");
  public static final Target AVAILABLE_CARS =
      Target.the("").locatedBy("//div[@class='offer-card-desktop']");
}
