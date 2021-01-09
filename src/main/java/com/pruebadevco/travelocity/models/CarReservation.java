package com.pruebadevco.travelocity.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarReservation extends Reservation {

  private String carServiceType;
  private String startTime;
  private String endTime;
  private boolean aarpMemberRateIncluded;
  private boolean bookRoundtrip;
  private boolean haveDiscountCode;
  private String preferredBrand;
  private String discountType;

  public CarReservation() {
    super();
  }

  public CarReservation(Map<String, String> carReservationDate) {
    super(carReservationDate);
    this.carServiceType = carReservationDate.get("carServiceType");
    this.startTime = carReservationDate.get("startTime");
    this.endTime = carReservationDate.get("endTime");
    this.aarpMemberRateIncluded =
        Boolean.parseBoolean(carReservationDate.get("aarpMemberRateIncluded"));
    this.bookRoundtrip = Boolean.parseBoolean(carReservationDate.get("bookRoundtrip"));
    this.haveDiscountCode = Boolean.parseBoolean(carReservationDate.get("haveDiscountCode"));
    this.preferredBrand = carReservationDate.get("preferredBrand");
    this.discountType = carReservationDate.get("discountType");
  }

  public String getCarServiceType() {
    return carServiceType;
  }

  public void setCarServiceType(String carServiceType) {
    this.carServiceType = carServiceType;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public boolean isAarpMemberRateIncluded() {
    return aarpMemberRateIncluded;
  }

  public void setAarpMemberRateIncluded(boolean aarpMemberRateIncluded) {
    this.aarpMemberRateIncluded = aarpMemberRateIncluded;
  }

  public boolean isBookRoundtrip() {
    return bookRoundtrip;
  }

  public void setBookRoundtrip(boolean bookRoundtrip) {
    this.bookRoundtrip = bookRoundtrip;
  }

  public boolean isHaveDiscountCode() {
    return haveDiscountCode;
  }

  public void setHaveDiscountCode(boolean haveDiscountCode) {
    this.haveDiscountCode = haveDiscountCode;
  }

  public String getPreferredBrand() {
    return preferredBrand;
  }

  public void setPreferredBrand(String preferredBrand) {
    this.preferredBrand = preferredBrand;
  }

  public String getDiscountType() {
    return discountType;
  }

  public void setDiscountType(String discountType) {
    this.discountType = discountType;
  }

  public static List<CarReservation> getCarReservations(
      List<Map<String, String>> carReservationList) {
    List<CarReservation> carReservations = new ArrayList<>();
    carReservationList.forEach(
        carReservation -> carReservations.add(new CarReservation(carReservation)));
    return carReservations;
  }
}
