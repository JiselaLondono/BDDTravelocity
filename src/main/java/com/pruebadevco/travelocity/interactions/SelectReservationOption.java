package com.pruebadevco.travelocity.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.pruebadevco.travelocity.userinterface.TravelocityReservations.RESERVATION_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectReservationOption implements Interaction {

    private String option;

    public SelectReservationOption(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(RESERVATION_OPTION.of(option)));
    }

    public static SelectReservationOption named(String option) {
        return instrumented(SelectReservationOption.class, option);
    }
}
