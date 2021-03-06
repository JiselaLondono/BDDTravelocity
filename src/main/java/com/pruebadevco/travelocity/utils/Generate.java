package com.pruebadevco.travelocity.utils;

import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.CAR_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.CRUISE_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.FLIGHT_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.HOTEL_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.CsvFileNames.THINGS_TO_DO_RESERVATION;
import static com.pruebadevco.travelocity.utils.enums.ErrorMessages.RESOURCE_NOT_FOUND_ERROR;

import com.pruebadevco.travelocity.models.CarReservation;
import com.pruebadevco.travelocity.models.CruiseReservation;
import com.pruebadevco.travelocity.models.FlightReservation;
import com.pruebadevco.travelocity.models.HotelReservation;
import com.pruebadevco.travelocity.models.ThingsToDoReservation;
import java.io.IOException;

public class Generate {

  public static HotelReservation getHotelReservationData(String filter) throws IOException {
    HotelReservation hotelReservationData;
    try {
      hotelReservationData =
          HotelReservation.getHotelReservations(
                  CsvUtilities.getDataTest(HOTEL_RESERVATION.getValue(), filter))
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
                  CsvUtilities.getDataTest(FLIGHT_RESERVATION.getValue(), filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return flightReservationData;
  }

  public static CarReservation getCarReservationData(String filter) throws IOException {
    CarReservation carReservationData;
    try {
      carReservationData =
          CarReservation.getCarReservations(
                  CsvUtilities.getDataTest(CAR_RESERVATION.getValue(), filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return carReservationData;
  }

  public static ThingsToDoReservation getThingsToDoReservationData(String filter)
      throws IOException {
    ThingsToDoReservation thingsToDoReservation;
    try {
      thingsToDoReservation =
          ThingsToDoReservation.getThingsToDoReservations(
                  CsvUtilities.getDataTest(THINGS_TO_DO_RESERVATION.getValue(), filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return thingsToDoReservation;
  }

  public static CruiseReservation getCruiseReservationData(String filter) throws IOException {
    CruiseReservation cruiseReservation;
    try {
      cruiseReservation =
          CruiseReservation.getCruiseReservations(
                  CsvUtilities.getDataTest(CRUISE_RESERVATION.getValue(), filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return cruiseReservation;
  }
}
