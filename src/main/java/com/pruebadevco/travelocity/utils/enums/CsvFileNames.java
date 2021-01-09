package com.pruebadevco.travelocity.utils.enums;

public enum CsvFileNames {
  HOTEL_RESERVATION("hotel_reservation"),
  FLIGHT_RESERVATION("flight_reservation");
  ;

  private String value;

  CsvFileNames(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
