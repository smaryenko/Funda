package nl.funda.BB.FundaTests.DD.Helpers;

import nl.funda.BB.FundaTests.AA.TestBase.TestBase;
import nl.funda.CC.Pages.PageSearchResults;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HelperSearchTests extends TestBase{
    public static void GoToSearchPage(){
        driver.get(PAGE_URL_BASE);
        HelpersSelenium.waitForPageToLoad(FIELD_SEARCH);
    }

    public static void addLocationSearchQuery(String location){
        HelpersSelenium.setText(FIELD_SEARCH, location);
    }

    public static void addAfstandSearchQuery(String value){
        HelpersSelenium.selectFromDropdown(DROPDOWN_AFSTAND, value);
    }

    public static void proceedWithValidSearchInput(){
        HelpersSelenium.clickAndWait(BUTTON_SEARCH, PageSearchResults.DIV_RESULTS);
    }

    public static void proceedWithInValidSearchInput(){
        HelpersSelenium.clickAndWait(BUTTON_SEARCH, PageSearchResults.MARK_RESULTS);
    }

    public static void checkInvalidSeach(String expectedText) {
        WebElement element = driver.findElement(PageSearchResults.MARK_RESULTS);
        Assert.assertEquals(expectedText, element.getText());
    }

    public static void backToMainPage(){
        driver.get(PAGE_URL_BASE);
        HelpersSelenium.waitForPageToLoad(LINK_QUICK_SEARCH);
    }

    public static void checkQuickSearchInput(String expectedText) {
        WebElement element = driver.findElement(LINK_QUICK_SEARCH);
        Assert.assertEquals(expectedText, element.getText());

    }

    public static void addMinPriceSearchQuery(String value, Boolean selectDefault){
        addPriceSearchQuery(DROPDOWN_PRICE_FROM, INPUT_PRICE_FROM, value, selectDefault);
    }

    public static void addMaxPriceSearchQuery(String value, Boolean selectDefault){
        addPriceSearchQuery(DROPDOWN_PRICE_TO, INPUT_PRICE_TO, value, selectDefault);
    }

    public static void addPriceSearchQuery(By dropdownSelector, String inputName, String value, Boolean selectDefault){
        if (!selectDefault) {
            HelpersSelenium.selectFromDropdown(dropdownSelector, "other");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(String.format("document.getElementsByName('%1$s')[1].setAttribute('value', '%2$s')", inputName, value));
        }else {
            HelpersSelenium.selectFromDropdown(dropdownSelector, value);
        }
    }
}
