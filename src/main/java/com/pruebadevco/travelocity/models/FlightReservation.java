package com.pruebadevco.travelocity.models;

public class FlightReservation /* extends Reservation*/ {

    private String typeOfFlight;
    private String checkInDate;
    private String checkOutDate;
    private boolean addAHotel;
    private boolean addACar;
    private String flightClass;

    public String getTypeOfFlight() {
        return typeOfFlight;
    }

    public void setTypeOfFlight(String typeOfFlight) {
        this.typeOfFlight = typeOfFlight;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isAddAHotel() {
        return addAHotel;
    }

    public void setAddAHotel(boolean addAHotel) {
        this.addAHotel = addAHotel;
    }

    public boolean isAddACar() {
        return addACar;
    }

    public void setAddACar(boolean addACar) {
        this.addACar = addACar;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}
