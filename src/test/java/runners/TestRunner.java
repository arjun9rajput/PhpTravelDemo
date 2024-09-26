package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utils.RetryListener;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"src/test/java/stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-report.json"
        },
        monochrome = true
)

@Listeners(RetryListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
        public static String mode;

        @BeforeClass
        @Parameters({"mode"})
        public void setup(String modeParam) {
                mode = modeParam;
        }
}
