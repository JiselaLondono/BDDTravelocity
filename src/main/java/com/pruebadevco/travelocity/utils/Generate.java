package com.pruebadevco.travelocity.utils;

import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.FLIGHT_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.HOTEL_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.RESOURCE_NOT_FOUND_ERROR;

import com.pruebadevco.travelocity.models.FlightReservation;
import com.pruebadevco.travelocity.models.HotelReservation;
import java.io.IOException;

public class Generate {

  public static HotelReservation getHotelReservationData(String filter) throws IOException {
    HotelReservation hotelReservationData;
    try {
      hotelReservationData =
          HotelReservation.getHotelReservations(
                  UtilidadesCSV.obtenerDatosPrueba(HOTEL_RESERVATION.getValue(), filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return hotelReservationData;
  }

  public static FlightReservation getFlightReservationData(String filter) throws IOException {
    FlightReservation flightReservationData;
    try {
      flightReservationData =
          FlightReservation.getFlightReservations(
                  UtilidadesCSV.obtenerDatosPrueba(FLIGHT_RESERVATION.getValue(), filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return flightReservationData;
  }
}