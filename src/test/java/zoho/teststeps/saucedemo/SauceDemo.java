package zoho.teststeps.saucedemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.StringValue;
import zoho.context.TestContext;
import zoho.pages.lassana.LassanaHomePage;
import zoho.pages.saucedemo.SauceDemoCartPage;
import zoho.pages.saucedemo.SauceDemoHomePage;
import zoho.pages.saucedemo.SauceDemoLoginPage;

public class SauceDemo {

        public TestContext context;
        public SauceDemoLoginPage sauceDemoLoginPage;
        public SauceDemoHomePage sauceDemoHomePage;
        public SauceDemoCartPage sauceDemoCartPage;

    public SauceDemo(TestContext context) {
        this.context=context;
        this.sauceDemoLoginPage=context.getPageObjectManager().getSauceDemoLoginPage();
        this.sauceDemoHomePage=context.getPageObjectManager().getSauceDemoHomePage();
        this.sauceDemoCartPage=context.getPageObjectManager().getSauceDemoCartPage();
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
            context.log("-------------------------------------------------");
        }


    @Given("Given I am landing in saucedemo.com and validate the page title")
    public void givenIAmLandingInLassanaComAndValidateThePageTitle() {
        sauceDemoLoginPage.load("Chrome");
    }

    @When("I log into the system with user name {string} and password {string}")
    public void iLogIntoTheSystemWithUserNameUserAndPasswordPassword(String username,String password) {
        sauceDemoLoginPage.login(username,password);
    }

    @When("I sort the products by price with criteria {string}")
    public void iSortTheProductsByPriceWithCriteriaCriteria(String criteria) {
        sauceDemoHomePage.sortProducts(criteria);
    }

    @When("I add the {string} cheapest products to my basket")
    public void iAddTheCheapestProductsToMyBasket(String NoOfitems) {
        sauceDemoHomePage.clickLastitesms(Integer. parseInt(NoOfitems));
    }

    @When("I open the basket")
    public void iOpenTheBasket() {
        sauceDemoHomePage.clickCart();
    }

    @When("I remove the product from basket price value less than {string}")
    public void iRemoveTheProductFromBasketPriceValueLessThan(String  value) {
        sauceDemoCartPage.removeCheapset(value);
    }

    @And("I checkout the cart")
    public void iCheckoutTheCart() {
        sauceDemoCartPage.checkout();
    }

    @When("I enter first name {string} last name {string} and zip code {string}")
    public void iEnterFirstNameFNameLastNameLNameAndZipCodeZipCode(String fname, String lname, String zip) {
        sauceDemoCartPage.fillPurchaseForm(fname,lname,zip);
    }

    @Then("I should see CHECKOUT: OVERVIEW page")
    public void iShouldSeeCHECKOUTOVERVIEWPage() {
        sauceDemoCartPage.VerifySuccessOfCheckout();
    }

    @When("I click finish button to complete the process")
    public void iClickFinishButtonToCompleteTheProcess() {
        sauceDemoCartPage.completeProcess();
    }

    @Then("I should see success message as {string}")
    public void iShouldSeeSuccessMessageAsTHANKYOUFORYOURORDER(String message) {
        sauceDemoCartPage.checkSuccessMessage(message);
    }
}

