package com.pruebadevco.travelocity.interactions;

import static com.pruebadevco.travelocity.interactions.SelectEndDate.selectDate;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.CALENDAR_MONTH;
import static com.pruebadevco.travelocity.userinterface.GeneralFilters.NEXT_MONTH;
import static com.pruebadevco.travelocity.utils.Constants.FULL_DATE_FORMAT;
import static com.pruebadevco.travelocity.utils.Utilities.getCurrentDate;
import static com.pruebadevco.travelocity.utils.Utilities.getMonthFromFullDate;
import static com.pruebadevco.travelocity.utils.Utilities.validateStartDate;
import static com.pruebadevco.travelocity.utils.enums.Months.getMonthNumber;
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
    if (validateStartDate(date, FULL_DATE_FORMAT)) {
      int month = getMonthNumber(CALENDAR_MONTH.resolveFor(actor).getText());
      while (month != getMonthFromFullDate(date, FULL_DATE_FORMAT)) {
        actor.attemptsTo(Click.on(NEXT_MONTH));
        month = getMonthNumber(CALENDAR_MONTH.resolveFor(actor).getText());
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
