package com.pruebadevco.travelocity.exceptions;

public class HotelNotFoundException extends AssertionError {

  public HotelNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
