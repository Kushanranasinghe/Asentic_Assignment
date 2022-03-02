package zoho.teststeps.lassana;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import zoho.context.TestContext;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.CnaNewsItemPage;
import zoho.pages.lassana.LassanaHomePage;

public class LassanaHome {

        public TestContext context;
        public LassanaHomePage lassanaHomePage;

    public LassanaHome(TestContext context) {
        this.context=context;
        this.lassanaHomePage=context.getPageObjectManager().getLassanaHomePage();
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


    @Given("Given I am landing in lassana.com and validate the page title")
    public void givenIAmLandingInLassanaComAndValidateThePageTitle() {
        lassanaHomePage.load("Chrome");
    }

    @When("I search {string} item in lassana site")
    public void iSearchProduct_nameItemInLassanaSite(String searchItem) {
        lassanaHomePage.SearchAnItem(searchItem);
    }

    @Then("I  verify the search text value as {string} in result page")
    public void iVerifyTheSearchTextValueAsProduct_nameInResultPage(String searchItem) {
        lassanaHomePage.verifySearchedProductIsCorrect(searchItem);
    }

}

