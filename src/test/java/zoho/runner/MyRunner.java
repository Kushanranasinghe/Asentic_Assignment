package zoho.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //features = "@rerun/failed_scenarios.txt",
		 features = "src/test/resources/featureFiles/saucedemo",
         glue = {"zoho.teststeps.saucedemo"},
        tags = "@saucedemo_buy",
         plugin = { "html:target/cucumber-reports.html","rerun:rerun/failed_scenarios.txt"},
         monochrome = false,
         dryRun = false
)
public class MyRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
