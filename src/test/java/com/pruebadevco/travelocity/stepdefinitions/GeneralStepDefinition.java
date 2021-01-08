package com.pruebadevco.travelocity.stepdefinitions;

import com.pruebadevco.travelocity.interactions.SelectReservationOption;
import com.pruebadevco.travelocity.models.HotelReservation;
import com.pruebadevco.travelocity.tasks.SearchHotelReservation;
import com.pruebadevco.travelocity.utils.UtilidadesCSV;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import static com.pruebadevco.travelocity.utils.Constants.TRAVELOCITY_URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class GeneralStepDefinition {

    @Managed(driver = "chrome")
    WebDriver herBrowser;

    @Before
    public void setStage(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
    }

    @Given("that {word} wants to use the {word} reservation service on Travelocity")
    public void selectReservationOption(String actor, String reservationOption) throws IOException {
        List<HotelReservation> hr = HotelReservation.getHotelReservations(UtilidadesCSV.obtenerDatosPrueba("hotel", "jise"));
        theActorCalled(actor).wasAbleTo(Open.url(TRAVELOCITY_URL), SelectReservationOption.named(reservationOption), SearchHotelReservation.withTheFollowingInformation(hr.get(0)));
    }


}
