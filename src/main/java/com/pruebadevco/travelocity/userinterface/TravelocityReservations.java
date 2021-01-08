package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class TravelocityReservations {

  public static final Target RESERVATION_OPTION =
      Target.the("Reservation option in Travelocity system")
          .locatedBy("//ul[@id='uitk-tabs-button-container']//span[text()='{0}']");

  private TravelocityReservations() {}
}
