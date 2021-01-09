package com.pruebadevco.travelocity.exceptions;

public class DifferentValueException extends AssertionError {

  public DifferentValueException(String message, Throwable cause) {
    super(message, cause);
  }
}
