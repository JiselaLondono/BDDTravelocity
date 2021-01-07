package com.pruebadevco.travelocity.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pruebadevco.travelocity.userinterface.TravelocityMenu.MENU_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectMenuOption implements Interaction {

    private String menuOption;

    public SelectMenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MENU_OPTION.of(menuOption)));
    }

    public static SelectMenuOption named(String menuOption) {
        return instrumented(SelectMenuOption.class, menuOption);
    }
}
