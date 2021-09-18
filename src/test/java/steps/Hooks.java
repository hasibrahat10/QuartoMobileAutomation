package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.FileHelper;

/**
 * Start and Stop Driver
 */
public class Hooks extends TestSetupPage {
    @Before
    public void setUpDriver(Scenario scenario) {
        scenarioName = scenario.getName();
        startDriver();
    }

    @After
    public void tearDown() {
        FileHelper.take_screenshot();
        stopDriver();
    }

}
