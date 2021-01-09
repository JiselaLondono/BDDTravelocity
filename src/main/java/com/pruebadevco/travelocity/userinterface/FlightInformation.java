package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class FlightInformation {
  public static final Target AVAILABLE_FLIGHTS =
      Target.the("List of available flights")
          .locatedBy("//ul[@id='flightModuleList']/li[@data-test-id='offer-listing']");
}
