package nl.funda.BB.FundaTests.BB.Tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nl.funda.BB.FundaTests.AA.TestBase.TestBase;
import nl.funda.BB.FundaTests.CC.TestData.TestDataQuickSearch;
import org.junit.*;
import org.junit.runner.RunWith;

import static nl.funda.BB.FundaTests.DD.Helpers.HelperSearchTests.*;


@RunWith(JUnitParamsRunner.class)
public class TestQuickSearch extends TestBase {

    @Before
    public void testInitialize(){
        GoToSearchPage();
    }

    @After
    public void testFinalize() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Parameters(source = TestDataQuickSearch.class, method = "testLocation_Success")
    public void test01_Location_Success(String testDescription, String locationInput, String afstandInput, String searchExpected){

        //Given
        addLocationSearchQuery(locationInput);
        addAfstandSearchQuery(afstandInput);

        //When
        proceedWithValidSearchInput();
        backToMainPage();

        //Then
        checkQuickSearchInput(searchExpected);
    }

    @Test
    @Parameters(source = TestDataQuickSearch.class, method = "testLocation_Invalid")
    public void test02_Location_Invalid(String testDescription, String locationInput, String searchExpected){

        //Given
        addLocationSearchQuery(locationInput);

        //When
        proceedWithInValidSearchInput();

        //Then
        checkInvalidSeach(searchExpected);
    }

    @Test
    @Parameters(source = TestDataQuickSearch.class, method = "testPrice_Success")
    public void test01_Price_Success(String testDescription, String priceMinInput, String priceMaxInput, Boolean useDefaultValues, String searchExpected) {

        //Given
        addMinPriceSearchQuery(priceMinInput, useDefaultValues);
        addMaxPriceSearchQuery(priceMaxInput, useDefaultValues);

        //When
        proceedWithValidSearchInput();
        backToMainPage();

        //Then
        checkQuickSearchInput(searchExpected);
    }

    @Test
    @Parameters(source = TestDataQuickSearch.class, method = "testPrice_Invalid")
    public void test02_Price_Invalid(String testDescription, String priceMinInput, String priceMaxInput, Boolean useDefaultValues, String searchExpected) {

        //Given
        addMinPriceSearchQuery(priceMinInput, useDefaultValues);
        addMaxPriceSearchQuery(priceMaxInput, useDefaultValues);

        //When
        proceedWithValidSearchInput();
        backToMainPage();

        //Then
        checkQuickSearchInput(searchExpected);
    }
}
