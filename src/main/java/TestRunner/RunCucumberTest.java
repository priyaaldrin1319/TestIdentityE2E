package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
            features = {"src/test/resources"},
            glue = {"StepDefinitions"},
            plugin = {
                    "pretty",
                    "html:target/cucumber-reports.html",
                    "json:target/cucumber.json",
                    "rerun:target/failed_scenarios.txt"
            }
    )
public class RunCucumberTest  {
    }




