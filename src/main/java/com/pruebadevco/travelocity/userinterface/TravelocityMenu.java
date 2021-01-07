package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class TravelocityMenu {
    public static final Target MENU_OPTION = Target.the("").locatedBy("//ul[@id='uitk-tabs-button-container']//span[text()='{0}']");
}
