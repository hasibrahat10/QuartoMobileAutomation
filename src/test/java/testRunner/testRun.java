package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        tags = {""},
        glue = "steps",
        monochrome = true,
        plugin = {"pretty", "html:test-output"}
)

public class testRun {
}
