package com.pruebadevco.travelocity.interactions;

import static com.pruebadevco.travelocity.interactions.SelectEndDate.selectDate;
import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.*;
import static com.pruebadevco.travelocity.utils.Constants.FULL_DATE_FORMAT;
import static com.pruebadevco.travelocity.utils.Constants.MONTH_FORMAT;
import static com.pruebadevco.travelocity.utils.Utilities.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectStartDate implements Interaction {

  private String date;

  public SelectStartDate(String date) {
    this.date = date;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(START_DATE_BUTTON));
    if (validateStartDate(date, FULL_DATE_FORMAT)) {
      int month =
          getMonthFromTextCalendar(CALENDAR_MONTH.resolveFor(actor).getText(), MONTH_FORMAT);
      while (month != getMonthFromFullDate(date, FULL_DATE_FORMAT)) {
        actor.attemptsTo(Click.on(NEXT_MONTH));
        month = getMonthFromTextCalendar(CALENDAR_MONTH.resolveFor(actor).getText(), MONTH_FORMAT);
      }
      selectDate(actor, date);
    } else {
      selectDate(actor, getCurrentDate(FULL_DATE_FORMAT));
    }
  }

  public static SelectStartDate onTheCalendar(String date) {
    return instrumented(SelectStartDate.class, date);
  }
}
