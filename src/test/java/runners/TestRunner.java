package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/changeBookingId.feature"}, // Path to your feature files
		glue = {"stepDefinitions"}, // Package where step definition files are
		dryRun = true, // Optional: Checks for steps without running the code
		plugin = {"pretty", "html:target/cucumber-reports/report.html","json:target/cucumber-reports/json-report.json"},
		monochrome = true)
public class TestRunner {

}
