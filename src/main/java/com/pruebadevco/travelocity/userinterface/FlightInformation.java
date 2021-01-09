package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class FlightInformation {

  public static final Target AVAILABLE_FLIGHTS =
      Target.the("Element containing the flights available information")
          .locatedBy("//ul[@id='flightModuleList']/li[@data-test-id='offer-listing']");

  public FlightInformation() {}
}
