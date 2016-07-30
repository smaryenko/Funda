package nl.funda.CC.Pages;

import org.openqa.selenium.By;

public interface PageSearchResults {
    By DIV_RESULTS = By.cssSelector("#content > form > div.container.search-main > div.search-output-result-count");

    By MARK_RESULTS = By.cssSelector("#content > div > div > h1 > span.location-suggestions-header-content > mark");
}
