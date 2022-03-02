package zoho.teststeps.amazon;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import zoho.context.TestContext;
import zoho.pages.amazon.AmazoneHomePage;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.CnaNewsItemPage;

public class AmazonHome {

    public TestContext context;
    public AmazoneHomePage amazoneHomePage;

    public AmazonHome(TestContext context) {
        this.context=context;
        this.amazoneHomePage=context.getPageObjectManager().amazoneHomePage();
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

    @Given("I am in amazon home page")
    public void iAmInAmazonHomePage() {

        amazoneHomePage.load("Chrome");
    }

    @When("I search {string} item")
    public void iSearchSearchTextItem(String itemName) {
        amazoneHomePage.searchAnItem(itemName);

    }
}

