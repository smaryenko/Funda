package nl.funda.BB.FundaTests.CC.TestData;

import nl.funda.BB.FundaTests.AA.TestBase.Constants;

import static junitparams.JUnitParamsRunner.$;

public class TestDataQuickSearch {

    public static Object[] testLocation_Success() {
        return $(
                $("Default Values",                 "",                           "0",                "Land Nederland"),
                $("Valid city (with space)",        "Den Haag",                   "1",                "Den Haag, +1 km"),
                $("Valid postcode",                 "1321TA",                     "2",                "Postcode 1321TA, +2 km"),
                $("Valid postcode with space",      "1069 ga",                    "5",                "Postcode 1069GA, +5 km"),
                $("Valid street (lower case)",      "hendrik marsmanstraat",      "10",               "Hendrik Marsmanstraat, Almere, +10 km"),
                $("Valid land (upper case)",        "FLEVOLAND",                  "15",               "Provincie Flevoland, +15 km"),
                $("Valid postcode no lettes",       "1321",                       "0",                "Postcode 1321"),
                $("Trim spaces",                    "    Almere   ",              "0",                "Almere"),
                $("Trim spaces only",               "    ",                       "0",                "Land Nederland")
        );
    }

    public static Object[] testLocation_Invalid() {
        return $(
                $("Invalid postcode",                 "1000ZZ",                                         "1000zz"),
                $("Invalid text",                     "blabla",                                         "blabla"),
                $("Invalid number",                   "-1",                                             "-1"),
                $("JS injection",                     "javascript:alert(document.cookie);",             "javascriptalertdocumentcookie"),
                $("Long string",                      Constants.LONG_STRING,                            Constants.LONG_STRING.toLowerCase()),
                $("SQL injection",                    "DROP table TABLE1;",                             "drop-table-table1"),

                //Failed tests
                $("XML injection",                    Constants.XML_CHARS,                              "stans&test"),
                $("UTF support",                      Constants.UTF_CHARS,                              "???"),
                $("sign which ignored???",            "sometext+",                                      "sometext+"),
                $("sign which searches all???",       "&",                                              "&"),
                $("sign which refreshes???",          "*",                                              "*")
        );
    }

    public static Object[] testPrice_Success() {
        return $(
                $("Default Values",                     "0",            "ignore_filter",         true,           "Land Nederland"),
                $("Default Values min max",             "50000",        "2000000",               true,           "Land Nederland, € 50.000 - € 2.000.000"),
                $("Custom  Values min max",             "1",            "99999999",              false,          "Land Nederland, € 1 - € 99.999.999"),
                $("Custom  Values points handled",      "500.234",      "1000000.10",            false,          "Land Nederland, € 500.234 - € 100.000.010"),
                $("Custom  Values small difference",    "999999",       "1000000",               false,          "Land Nederland, € 999.999 - € 1.000.000"),
                $("Custom  Values min max + 1",         "1",            "100000000",             false,          "Land Nederland, € 1 - € 100.000.000"),
                $("Custom  Values min max length",      "1",            "1000000000",            false,          "Land Nederland, € 1 - € 1.000.000.000"),

                //Failed tests
                $("Custom  Values + support",           "+1",           "+1000000",              false,          "Land Nederland, € 1 - € 1.000.000"),
                $("Custom  Values e support",           "10e3",         "10e6",                  false,          "Land Nederland, € 1000 - € 1.000.000"),
                $("Custom  Values - support",           "-5",           "100000000",             false,          "Land Nederland, € 0 - € 1.000.000")
        );
    }

    public static Object[] testPrice_Invalid() {
        return $(
                $("min more than max default",          "250000",        "50000",                true,           "Land Nederland, € 250.000 - € 50.000"),
                $("min more than max custom",           "1000000",       "999999",               false,          "Land Nederland, € 1.000.000 - € 999.999"),
                $("very long",                          "-1000000000000","10000000000000",       false,          "Land Nederland, € 0 - € 0")
        );
    }
}
