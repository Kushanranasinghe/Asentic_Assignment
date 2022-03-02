package zoho.managers;

import zoho.pages.amazon.AmazonSearchResultPage;
import zoho.pages.amazon.AmazoneHomePage;
import zoho.pages.cna.CnaHomePage;
import zoho.pages.cna.CnaInternationalPage;
import zoho.pages.cna.CnaNewsItemPage;
import zoho.pages.cna.TopMenuComponent;
import zoho.pages.lassana.LassanaHomePage;
import zoho.pages.lassana.LassanaProductPage;
import zoho.pages.saucedemo.SauceDemoCartPage;
import zoho.pages.saucedemo.SauceDemoHomePage;
import zoho.pages.saucedemo.SauceDemoLoginPage;

public class PageObjectManager {

	TopMenuComponent topMenu;


	CnaHomePage cnaHomePage;
	CnaNewsItemPage cnaNewsItemPage;
	CnaInternationalPage cnaInternationalPage;
	AmazoneHomePage amazoneHomePage;
	AmazonSearchResultPage amazonSearchResultPage;
	LassanaHomePage lassanaHomePage;
	LassanaProductPage lassanaProductPage;
	SauceDemoLoginPage sauceDemoLoginPage;
	SauceDemoHomePage sauceDemoHomePage;
	SauceDemoCartPage sauceDemoCartPage;

	WebDriverManager app;
	
	public PageObjectManager() {
		this.app = new WebDriverManager();
	}
	
	
	public WebDriverManager getWebDriverManager() {
		return app;
	}

	public AmazoneHomePage amazoneHomePage() {
		if(amazoneHomePage == null)
			amazoneHomePage = new AmazoneHomePage(app);
		return amazoneHomePage;
	}

	public AmazonSearchResultPage amazonSearchResultPage() {
		if(amazonSearchResultPage == null)
			amazonSearchResultPage = new AmazonSearchResultPage(app);
		return amazonSearchResultPage;
	}

	public CnaHomePage getCnaHomePage() {
		if(cnaHomePage == null)
			cnaHomePage = new CnaHomePage(app);
		return cnaHomePage;
	}

	public CnaInternationalPage getCnaInternationalPage() {
		if(cnaInternationalPage == null)
			cnaInternationalPage = new CnaInternationalPage(app);
		return cnaInternationalPage;
	}

	public CnaNewsItemPage getCnaNewsItemPage() {
		if(cnaNewsItemPage == null)
			cnaNewsItemPage = new CnaNewsItemPage(app);
		return cnaNewsItemPage;
	}


	public TopMenuComponent getTopMenu() {
		if(topMenu == null)
			topMenu = new TopMenuComponent(app);
		return topMenu;
	}

	public  LassanaHomePage getLassanaHomePage(){
		if(lassanaHomePage == null)
			lassanaHomePage = new LassanaHomePage(app);
		return lassanaHomePage;
	}

	public  LassanaProductPage getLassanaProductPage(){
		if(lassanaProductPage == null)
			lassanaProductPage = new LassanaProductPage(app);
		return lassanaProductPage;
	}

	public  SauceDemoLoginPage getSauceDemoLoginPage(){
		if(sauceDemoLoginPage == null)
			sauceDemoLoginPage = new SauceDemoLoginPage(app);
		return sauceDemoLoginPage;
	}

	public SauceDemoHomePage getSauceDemoHomePage(){
		if(sauceDemoHomePage == null)
			sauceDemoHomePage = new SauceDemoHomePage(app);
		return sauceDemoHomePage;
	}

	public SauceDemoCartPage getSauceDemoCartPage(){
		if(sauceDemoCartPage == null)
			sauceDemoCartPage = new SauceDemoCartPage(app);
		return sauceDemoCartPage;
	}

}

