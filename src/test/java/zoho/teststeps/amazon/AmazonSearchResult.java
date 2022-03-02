package zoho.teststeps.amazon;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import zoho.context.TestContext;
import zoho.pages.amazon.AmazonSearchResultPage;
import zoho.pages.amazon.AmazoneHomePage;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.CnaNewsItemPage;

public class AmazonSearchResult {

    public TestContext context;
    public AmazoneHomePage amazoneHomePage;
    public AmazonSearchResultPage amazonSearchResultPage;

    public AmazonSearchResult(TestContext context) {
        this.context=context;
        this.amazoneHomePage=context.getPageObjectManager().amazoneHomePage();
        this.amazonSearchResultPage=context.getPageObjectManager().amazonSearchResultPage();
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

    @When("I should see searched item of {string}")
    public void iSeeSearchedItem(String itemName) {
        amazonSearchResultPage.IsItemDisplayed(itemName);
    }
}
