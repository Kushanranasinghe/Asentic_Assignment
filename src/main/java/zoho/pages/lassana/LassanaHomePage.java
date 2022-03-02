package zoho.pages.lassana;

import org.testng.Assert;
import zoho.managers.WebDriverManager;
import zoho.pages.cna.CnaNewsItemPage;

public class LassanaHomePage {


    WebDriverManager app;
    CnaNewsItemPage cnaNewsItemPage;

    public LassanaHomePage(WebDriverManager app) {
        this.app=app;
    }

    public void load(String browser) { // open browser and navigate it to home page
        app.log("Trying to load home page after launching browser");
        app.openBrowser(browser);
        app.navigate("url");
        if(!app.verifyTitle("homepagetitle"))
            app.logFailure("Titles did not match",false);
    }


    public void SearchAnItem(String searchItem) {
        app.click("searchingBar");
        app.type("searchingBar",searchItem);
        app.click("searchIcon");

    }

    public void verifySearchedProductIsCorrect(String searchItem) {
        Assert.assertEquals(app.findElement("productNamelabel").getText(),searchItem,"Item is not matched with searched one");
    }
}
