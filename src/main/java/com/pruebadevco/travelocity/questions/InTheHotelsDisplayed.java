package com.pruebadevco.travelocity.questions;

import static com.pruebadevco.travelocity.userinterface.HotelInformation.HOTEL_NAME;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class InTheHotelsDisplayed implements Question<Boolean> {

  private String hotelName;

  public InTheHotelsDisplayed(String hotelName) {
    this.hotelName = hotelName;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return HOTEL_NAME.of(hotelName).resolveFor(actor).isVisible();
  }

  public static InTheHotelsDisplayed theHotel(String hotelName) {
    return new InTheHotelsDisplayed(hotelName);
  }
}
