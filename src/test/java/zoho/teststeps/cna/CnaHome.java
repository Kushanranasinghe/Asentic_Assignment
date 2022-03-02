package zoho.teststeps.cna;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import zoho.context.TestContext;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.CnaNewsItemPage;

public class CnaHome {

        public TestContext context;
        public CnaHomePage cnaHomePage;
        public CnaNewsItemPage cnaNewsItemPage;

    public CnaHome(TestContext context) {
            this.context=context;
        this.cnaHomePage=context.getPageObjectManager().getCnaHomePage();
        this.cnaNewsItemPage=context.getPageObjectManager().getCnaNewsItemPage();
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

    @Given("Given I am landing in cna.com")
    public void givenIAmLandingInCnaCom() {
        cnaHomePage.load("Chrome");
    }

    @Given("I should see the headline news item Title")
    public void iShouldSeeTheHeadlineNewsItemTitle() {
        Assert.assertTrue(cnaHomePage.validateHeadlineNews());
    }

    @And("I click on Headline news")
    public void iClickOnHeadlineNews() {
        cnaHomePage.clickHeadlineNews();
    }


    @Then("I should see the actual story as {string} for the headline")
    public void iShouldSeeTheActualStoryAsHeadlineForTheHeadline(String Headline) throws Throwable {
        cnaNewsItemPage.ValidateStoryOfHeadline(Headline.trim().replaceAll("[-+.^:,']",""));
    }

    @And("I scroll the browser")
    public void iScrollTheBrowser() throws InterruptedException {
        cnaNewsItemPage.scrolldown();
    }

    @And("I click {string} news item")
    public void iClickNewsNoNewsItem(String newsNo) {
        int no = Integer.parseInt(newsNo);
        cnaNewsItemPage.clickANewsItem(no);
    }
}

