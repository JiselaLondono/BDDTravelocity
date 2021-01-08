package com.pruebadevco.travelocity.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class HotelSearchFilters {
    public static final Target DESTINATION_PLACE_BUTTON = Target.the("").locatedBy("//div[@id='location-field-destination-menu']//button");
    public static final Target PLACE_SEARCH_TEXT = Target.the("").locatedBy("//div[@class='uitk-menu-container elevation-8 uitk-menu-open uitk-menu-pos-left']//input");
    public static final Target PLACE_SEARCH_LIST = Target.the("").locatedBy("//div[@class='uitk-menu-container elevation-8 uitk-menu-open uitk-menu-pos-left']//li//strong[text()='{0}']//ancestor::button");
    public static final Target START_DATE_BUTTON = Target.the("").located(By.id("d1-btn"));
    public static final Target END_DATE_BUTTON = Target.the("").located(By.id("d2-btn"));

}
