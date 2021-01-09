package com.pruebadevco.travelocity.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightReservation extends Reservation {

  private String flightType;
  private String checkInDate;
  private String checkOutDate;
  private boolean addAHotel;
  private boolean addACar;
  private String preferredClass;

  public FlightReservation() {
    super();
  }

  private FlightReservation(Map<String, String> flightReservationData) {
    super(flightReservationData);
    this.flightType = flightReservationData.get("flightType");
    this.checkInDate = flightReservationData.get("checkInDate");
    this.checkOutDate = flightReservationData.get("checkOutDate");
    this.addAHotel = Boolean.parseBoolean(flightReservationData.get("addAHotel"));
    this.addACar = Boolean.parseBoolean(flightReservationData.get("addACar"));
    this.preferredClass = flightReservationData.get("preferredClass");
  }

  public String getFlightType() {
    return flightType;
  }

  public void setFlightType(String flightType) {
    this.flightType = flightType;
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

  public boolean isAddAHotel() {
    return addAHotel;
  }

  public void setAddAHotel(boolean addAHotel) {
    this.addAHotel = addAHotel;
  }

  public boolean isAddACar() {
    return addACar;
  }

  public void setAddACar(boolean addACar) {
    this.addACar = addACar;
  }

  public String getPreferredClass() {
    return preferredClass;
  }

  public void setPreferredClass(String preferredClass) {
    this.preferredClass = preferredClass;
  }

  public static List<FlightReservation> getFlightReservations(
      List<Map<String, String>> hotelReservationList) {
    List<FlightReservation> flightReservations = new ArrayList<>();
    hotelReservationList.forEach(
        flightReservation -> flightReservations.add(new FlightReservation(flightReservation)));
    return flightReservations;
  }
}
