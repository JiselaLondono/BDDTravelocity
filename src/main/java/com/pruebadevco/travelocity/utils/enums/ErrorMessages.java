package com.pruebadevco.travelocity.utils.enums;

public enum ErrorMessages {
  RESOURCE_NOT_FOUND_ERROR("No se encontró el recurso requerido");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
