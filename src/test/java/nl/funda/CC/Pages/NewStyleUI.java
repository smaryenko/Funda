package nl.funda.CC.Pages;

import org.openqa.selenium.By;

public interface NewStyleUI {
    By FIELD_SEARCH = By.id("autocomplete-input");

    By BUTTON_SEARCH = By.xpath("//*[@id=\"content\"]/div[1]/div[4]/div[1]/form/div/button");

    By LINK_QUICK_SEARCH = By.cssSelector("#content > div.home-search > div.search-block.has-price-range > div.search-block-body > p > a");

    By DROPDOWN_AFSTAND = By.id("Afstand");
    By DROPDOWN_PRICE_FROM = By.id("price-selector-from");
    By DROPDOWN_PRICE_TO = By.id("price-selector-to");

    String INPUT_PRICE_FROM = "filter_FundaKoopPrijsVan";
    String INPUT_PRICE_TO = "filter_FundaKoopPrijsTot";
}
