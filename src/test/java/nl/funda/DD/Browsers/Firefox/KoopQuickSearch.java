package nl.funda.DD.Browsers.Firefox;

import nl.funda.BB.FundaTests.BB.Tests.TestQuickSearch;
import nl.funda.CC.Pages.PageKoop;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KoopQuickSearch extends TestQuickSearch implements PageKoop {

    @BeforeClass
    public static void classInitialize(){
        PAGE_URL_BASE = PAGE_URL;
        driver = new FirefoxDriver();
        driverWait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void classCleanup(){
        driver.close();
    }

}
