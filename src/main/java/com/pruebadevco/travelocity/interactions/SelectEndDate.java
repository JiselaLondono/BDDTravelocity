package com.pruebadevco.travelocity.interactions;

import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.*;
import static com.pruebadevco.travelocity.userinterface.HotelSearchFilters.APPLY_DATE_BUTTON;
import static com.pruebadevco.travelocity.utils.Constants.FULL_DATE_FORMAT;
import static com.pruebadevco.travelocity.utils.Constants.MONTH_FORMAT;
import static com.pruebadevco.travelocity.utils.Utilities.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectEndDate implements Interaction {

  private String endDate;
  private String startDate;

  public SelectEndDate(String endDate, String startDate) {
    this.endDate = endDate;
    this.startDate = startDate;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(END_DATE_BUTTON));
    if (validateDate(endDate, startDate, FULL_DATE_FORMAT)) {
      if (validateEndDate(endDate, FULL_DATE_FORMAT)) {
        int month =
            getMonthFromTextCalendar(CALENDAR_MONTH.resolveFor(actor).getText(), MONTH_FORMAT);
        while (month != getMonthFromFullDate(endDate, FULL_DATE_FORMAT)) {
          actor.attemptsTo(Click.on(NEXT_MONTH));
          month =
              getMonthFromTextCalendar(CALENDAR_MONTH.resolveFor(actor).getText(), MONTH_FORMAT);
        }
        selectDate(actor, endDate);
      } else {
        selectDate(actor, getFutureOrPastDate(FULL_DATE_FORMAT, 1));
      }
    } else {
      if (validateStartDate(startDate, FULL_DATE_FORMAT)) {
        selectDate(actor, getFutureOrPastDate(startDate, FULL_DATE_FORMAT, 1));
      } else {
        selectDate(actor, getFutureOrPastDate(FULL_DATE_FORMAT, 1));
      }
    }
  }

  public static void selectDate(Actor actor, String date) {
    actor.attemptsTo(
        Click.on(DATE_SELECT.of(Integer.toString(getDayDate(date, FULL_DATE_FORMAT)))),
        Click.on(APPLY_DATE_BUTTON));
  }

  public static SelectEndDate onTheCalendar(String endDate, String startDate) {
    return instrumented(SelectEndDate.class, endDate, startDate);
  }
}
