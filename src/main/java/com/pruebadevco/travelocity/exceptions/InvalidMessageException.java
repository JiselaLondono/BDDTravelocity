package com.pruebadevco.travelocity.exceptions;

public class InvalidMessageException extends AssertionError {

  public InvalidMessageException(String message, Throwable cause) {
    super(message, cause);
  }
}
