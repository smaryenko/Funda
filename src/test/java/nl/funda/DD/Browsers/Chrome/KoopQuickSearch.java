package nl.funda.DD.Browsers.Chrome;

import nl.funda.CC.Pages.PageKoop;
import nl.funda.BB.FundaTests.BB.Tests.TestQuickSearch;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KoopQuickSearch extends TestQuickSearch implements PageKoop {

    @BeforeClass
    public static void classInitialize(){
        PAGE_URL_BASE = PAGE_URL;
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void classCleanup(){
        driver.close();
    }

}
