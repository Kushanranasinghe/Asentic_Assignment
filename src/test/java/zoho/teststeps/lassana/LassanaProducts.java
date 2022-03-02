package zoho.teststeps.lassana;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zoho.context.TestContext;
import zoho.pages.lassana.LassanaHomePage;
import zoho.pages.lassana.LassanaProductPage;

public class LassanaProducts {

        public TestContext context;
        public LassanaHomePage lassanaHomePage;
        public LassanaProductPage lassanaProductPage;

    public LassanaProducts(TestContext context) {
        this.context=context;
        this.lassanaHomePage=context.getPageObjectManager().getLassanaHomePage();
        this.lassanaProductPage=context.getPageObjectManager().getLassanaProductPage();
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

    @When("I redirect to the {string}  page")
    public void iRedirectToTheProduct_namePage() {
    }

    @Then("I verify the page title")
    public void iVerifyThePageTitle() {
    }

    @When("I click on Logo on left top corner")
    public void iClickOnLogoOnLeftTopCorner() {
    }
}

