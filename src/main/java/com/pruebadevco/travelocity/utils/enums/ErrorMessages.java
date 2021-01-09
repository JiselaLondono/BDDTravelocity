package com.pruebadevco.travelocity.utils.enums;

public enum ErrorMessages {
  RESOURCE_NOT_FOUND_ERROR("Required resource not found"),
  HOTEL_NOT_FOUND_ERROR("Hotel %s was not found within the list of available hotels"),
  SEARCH_FILTER_NOT_APPLIED_ERROR("The search filter %s was not applied to the available items"),
  MESSAGE_EXPECTED_ERROR("The following screen message was expected: %s"),
  DIFFERENT_VALUE_ERROR("Compared values do not match");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
