package com.pruebadevco.travelocity.models;

import java.util.Map;

public abstract class Reservation {

    private String departurePlace;
    private String destinationPlace;
    private String startDate;
    private String endDate;

    public Reservation(Map<String, String> reservation) {
        this.departurePlace = reservation.get("departurePlace");
        this.destinationPlace = reservation.get("destinationPlace");
        this.startDate = reservation.get("startDate");
        this.endDate = reservation.get("endDate");

    }

    public Reservation() {
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
