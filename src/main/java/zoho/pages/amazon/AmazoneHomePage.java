package zoho.pages.amazon;

import zoho.managers.WebDriverManager;
import zoho.pages.cna.CnaNewsItemPage;

public class AmazoneHomePage {


    WebDriverManager app;

    public AmazoneHomePage(WebDriverManager app) {
        this.app=app;
    }

    public void load(String browser) { // open browser and navigate it to home page
        app.log("Trying to load home page after launching browser");
        app.openBrowser(browser);
        app.navigate("url");
        //app.findElement("try").click();
        app.click("try");
       // if(!app.verifyTitle("homepagetitle"))
           // app.logFailure("Titles did not match",false);
    }

    public Boolean validateHeadlineNews(){
        return app.isElementPresent("headline_xp");
    }


    public void searchAnItem(String itemName) {
        //app.findElement("search").click();
        app.click("search");
        //app.findElement("searchBar").sendKeys(itemName);
        app.type("searchBar",itemName);
        //app.findElement("searchButton").click();
        app.click("searchButton");
    }
}

