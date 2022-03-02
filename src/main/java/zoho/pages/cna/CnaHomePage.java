package zoho.pages.cna;

import zoho.managers.WebDriverManager;

public class CnaHomePage {


    WebDriverManager app;
    CnaNewsItemPage cnaNewsItemPage;

    public CnaHomePage(WebDriverManager app) {
        this.app=app;
    }

    public void load(String browser) { // open browser and navigate it to home page
        app.log("Trying to load home page after launching browser");
        app.openBrowser(browser);
        app.navigate("url");
        if(!app.verifyTitle("homepagetitle"))
            app.logFailure("Titles did not match",false);
    }

    public Boolean validateHeadlineNews(){
        return app.isElementPresent("headline_xp");
    }

    public CnaNewsItemPage clickHeadlineNews() {
        app.click("headline_xp");
        return cnaNewsItemPage;
    }


}
