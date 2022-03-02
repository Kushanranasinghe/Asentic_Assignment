package zoho.teststeps.cna;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import zoho.context.TestContext;

public class Landing {
    public TestContext context;

    public Landing(TestContext context) {
        this.context=context;
    }

    @Before
    public void before(Scenario scenario) {
        context.createScenario(scenario.getName());
        context.log("Starting scenario "+ scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        context.log("Ending scenario "+ scenario.getName());
        context.endScenario();
        context.getPageObjectManager().getWebDriverManager().quit();
        System.out.println("-------------------------------------------------");
    }
}
