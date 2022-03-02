package zoho.pages.saucedemo;

import org.testng.Assert;
import zoho.managers.WebDriverManager;
import zoho.pages.cna.CnaNewsItemPage;

public class SauceDemoLoginPage {


    WebDriverManager app;

    public SauceDemoLoginPage(WebDriverManager app) {
        this.app=app;
    }

    public void load(String browser) { // open browser and navigate it to home page
        app.log("Trying to load login page after launching browser");
        app.openBrowser(browser);
        app.navigate("url");
        if(!app.verifyTitle("SauceLoginpagetitle"))
            app.logFailure("Titles did not match",false);
    }

    public SauceDemoHomePage login(String username,String password){
        app.type("txt_username_xp",username);
        app.type("txt_password_xp",password);
        app.click("login_btn_xp");
        app.log("login success !");
        return new SauceDemoHomePage(new WebDriverManager());
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
