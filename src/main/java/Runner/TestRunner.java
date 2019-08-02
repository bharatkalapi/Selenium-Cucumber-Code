package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "D:\\SeleniumBDD\\BDDFrameworkDemo\\src\\main\\java\\Feature",
		glue = {"StepDefination"},
		format = {"pretty","html:test-output"},
		monochrome = true
)

public class TestRunner {

}
