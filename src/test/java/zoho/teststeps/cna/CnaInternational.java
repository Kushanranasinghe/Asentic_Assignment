package zoho.teststeps.cna;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zoho.context.TestContext;
import zoho.managers.WebDriverManager;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.CnaInternationalPage;
import zoho.pages.cna.CnaNewsItemPage;

public class CnaInternational {
    public TestContext context;
    public CnaHomePage cnaHomePage;
    public CnaNewsItemPage cnaNewsItemPage;
    public CnaInternationalPage cnaInternationalPage;
    public WebDriverManager webDriverManager;

    public CnaInternational(TestContext context) {
        this.context=context;
        this.cnaHomePage=context.getPageObjectManager().getCnaHomePage();
        this.cnaNewsItemPage=context.getPageObjectManager().getCnaNewsItemPage();
        this.cnaInternationalPage=context.getPageObjectManager().getCnaInternationalPage();
        this.webDriverManager=context.getPageObjectManager().getWebDriverManager();
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

    @Given("Given I am landing in cna International")
    public void givenIAmLandingInCnaInternational() {
        cnaInternationalPage.load("Chrome");
    }


    @When("I click {string} value from All selecter menu")
    public void iClickWetherValueFromAllSelecterMenu(String menuItem) {
        webDriverManager.clickAllSection(menuItem);
    }


    @Then("I check temperature of {string} should equal to {string}")
    public void iCheckTemperatureOfCityShouldEqualToTemperature(String city, String temp) {
        cnaInternationalPage.checkTheTemperature(city, temp);
    }

    @Then("I check condition of {string} should equal to {string}")
    public void iCheckConditionOfCityShouldEqualToCondition(String city, String condition) {
        cnaInternationalPage.checkTheCondition(city, condition);
    }

    @When("I click {string} to switch from international")
    public void iClickCountryToSwitchFromInternational(String country) {
        webDriverManager.clickMenuItem(country);
    }
}
