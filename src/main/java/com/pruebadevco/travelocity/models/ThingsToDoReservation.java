package com.pruebadevco.travelocity.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThingsToDoReservation extends Reservation {

  public ThingsToDoReservation(Map<String, String> thingsToDoReservation) {
    super(thingsToDoReservation);
  }

  public static List<ThingsToDoReservation> getThingsToDoReservations(
      List<Map<String, String>> thingsToDoReservationList) {
    List<ThingsToDoReservation> thingsToDoReservations = new ArrayList<>();
    thingsToDoReservationList.forEach(
        hotelReservation ->
            thingsToDoReservations.add(new ThingsToDoReservation(hotelReservation)));
    return thingsToDoReservations;
  }
}
