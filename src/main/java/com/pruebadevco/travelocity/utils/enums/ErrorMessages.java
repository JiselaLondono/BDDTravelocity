package com.pruebadevco.travelocity.utils.enums;

public enum ErrorMessages {
  RESOURCE_NOT_FOUND_ERROR("No se encontró el recurso requerido"),
  HOTEL_NOT_FOUND_ERROR("No se encontró el hotel %s dentro del listado de hoteles disponibles"),
  SEARCH_FILTER_NOT_APPLIED_ERROR(
      "El filtro de búsqueda %s no fue aplicado a alguno de los vuelos disponibles"),
  MESSAGE_EXPECTED_ERROR("Se esperaba el siguiente mensaje en pantalla: %s"),
  DIFFERENT_VALUE_ERROR("Los valores comparados no coinciden");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
