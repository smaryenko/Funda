package nl.funda.AA.Runner;

import nl.funda.DD.Browsers.Chrome.KoopQuickSearch;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Runner.Chrome.class/*, Runner.Firefox.class*/})
public class Runner {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            nl.funda.DD.Browsers.Chrome.KoopQuickSearch.class/*,
            nl.funda.DD.Browsers.Chrome.HuurQuickSearch.class*/
    })
    public static class Chrome {
    }

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
/*            nl.funda.DD.Browsers.Firefox.KoopQuickSearch.class,
            nl.funda.DD.Browsers.Firefox.HuurQuickSearch.class*/
    })
    public static class Firefox {
    }

}

