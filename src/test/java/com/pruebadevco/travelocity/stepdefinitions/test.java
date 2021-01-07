package com.pruebadevco.travelocity.stepdefinitions;

import com.pruebadevco.travelocity.interactions.SelectMenuOption;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.*;


public class test {

    @Managed
    private WebDriver herBrowser;

    @Before
    public void setStage(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
    }

    @Given("^(.*) quiere hacer uso del servicio de reservas de (.*) presente en Travelocity$")
    public void jiselaQuiereHacerUsoDelServicioDeReservasDeHotelesPresenteEnTravelocity(String actor, String menuOption) {
        theActorCalled(actor).wasAbleTo(Open.url("https://www.travelocity.com"));
        theActorInTheSpotlight().wasAbleTo(SelectMenuOption.named(menuOption));
    }

}
