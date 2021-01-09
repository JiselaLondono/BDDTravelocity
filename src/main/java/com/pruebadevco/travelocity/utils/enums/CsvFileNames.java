package com.pruebadevco.travelocity.utils.enums;

public enum CsvFileNames {
  HOTEL_RESERVATION("hotel_reservation"),
  FLIGHT_RESERVATION("flight_reservation"),
  CAR_RESERVATION("car_reservation"),
  THINGS_TO_DO_RESERVATION("things_to_do"),
  CRUISE_RESERVATION("cruise_reservation");

  private String value;

  CsvFileNames(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
