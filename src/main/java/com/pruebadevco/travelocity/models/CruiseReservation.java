package com.pruebadevco.travelocity.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CruiseReservation extends Reservation {
  public CruiseReservation(Map<String, String> cruisesReservation) {
    super(cruisesReservation);
  }

  public static List<CruiseReservation> getCruiseReservations(
      List<Map<String, String>> cruiseReservationList) {
    List<CruiseReservation> cruiseReservations = new ArrayList<>();
    cruiseReservationList.forEach(
        cruiseReservation -> cruiseReservations.add(new CruiseReservation(cruiseReservation)));
    return cruiseReservations;
  }
}
