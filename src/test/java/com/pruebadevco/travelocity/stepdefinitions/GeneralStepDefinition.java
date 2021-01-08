package com.pruebadevco.travelocity.stepdefinitions;

import static com.pruebadevco.travelocity.utils.Constants.TRAVELOCITY_URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import com.pruebadevco.travelocity.interactions.SelectReservationOption;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class GeneralStepDefinition {

  @Managed(driver = "chrome")
  WebDriver herBrowser;

  @Before
  public void setStage() {
    OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
  }

  @Given("that {word} wants to use the {word} reservation service on Travelocity")
  public void selectReservationOption(String actor, String reservationOption) {
    theActorCalled(actor)
        .wasAbleTo(Open.url(TRAVELOCITY_URL), SelectReservationOption.named(reservationOption));
  }
}
