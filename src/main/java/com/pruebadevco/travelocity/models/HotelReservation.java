package com.pruebadevco.travelocity.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelReservation extends Reservation {

  private String checkInDate;
  private String checkOutDate;
  private boolean addAFlight;
  private boolean addACar;

  public HotelReservation() {
    super();
  }

  private HotelReservation(Map<String, String> hotelReservationData) {
    super(hotelReservationData);
    this.checkInDate = hotelReservationData.get("checkInDate");
    this.checkOutDate = hotelReservationData.get("checkOutDate");
    this.addAFlight = Boolean.parseBoolean(hotelReservationData.get("addAFlight"));
    this.addACar = Boolean.parseBoolean(hotelReservationData.get("addACar"));
  }

  public String getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
  }

  public String getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(String checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public boolean isAddAFlight() {
    return addAFlight;
  }

  public void setAddAFlight(boolean addAFlight) {
    this.addAFlight = addAFlight;
  }

  public boolean isAddACar() {
    return addACar;
  }

  public void setAddACar(boolean addACar) {
    this.addACar = addACar;
  }

  public static List<HotelReservation> getHotelReservations(
      List<Map<String, String>> hotelReservationList) {
    List<HotelReservation> hotelReservations = new ArrayList<>();
    hotelReservationList.forEach(
        hotelReservation -> hotelReservations.add(new HotelReservation(hotelReservation)));
    return hotelReservations;
  }
}
