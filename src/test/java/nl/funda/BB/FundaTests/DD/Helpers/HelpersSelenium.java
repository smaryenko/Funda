package nl.funda.BB.FundaTests.DD.Helpers;

import nl.funda.BB.FundaTests.AA.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HelpersSelenium extends TestBase{

    public static void clickAndWait(By locatorForClick, By locatorForWait) {
        driver.findElement(locatorForClick).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(locatorForWait));
    }

    public static void setText(By locatorForText, String text) {
        WebElement element = driver.findElement(locatorForText);
        element.clear();
        element.sendKeys(new CharSequence[]{text});
    }

    public static void clickAndWait(By locatorForClick, String text) {
        driver.findElement(locatorForClick).click();

        driverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return driver.getPageSource().contains("text");
            }
        });
    }

    public static void waitForPageToLoad(By locatorForWait) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(locatorForWait));
    }

    public static void selectFromDropdown(By locatorForDropdown, String valueToSelect) {

        Select select = new Select(driver.findElement(locatorForDropdown));
        select.selectByValue(valueToSelect);
    }
}
