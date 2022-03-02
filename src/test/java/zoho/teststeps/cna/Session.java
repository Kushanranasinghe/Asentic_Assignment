package zoho.teststeps.cna;

import io.cucumber.java.en.Given;
import zoho.context.TestContext;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.HomePage;
import zoho.pages.cna.LoginPage;

public class Session {
    public TestContext context;
	public CnaHomePage cnaHomePage;

    public HomePage homePage;
    public LoginPage loginPage;
	
	public Session(TestContext context) {
		this.context=context;
	}
	
	@Given("I am logged in zoho.com")
	public void zohoLogin() {
		context.log("I am logged in zoho.com");
		homePage.load("Chrome");
		homePage.gotoLoginPage();
		loginPage.doLogin();
	}

	@Given("I am landing in cna.com")
	public void cnalanding() {
		context.log("I am landing in cna.com");
		//homePage.load("Chrome");
		//cnaHomePage.load("Chrome");
		//homePage.gotoLoginPage();
		//loginPage.doLogin();
	}


}
