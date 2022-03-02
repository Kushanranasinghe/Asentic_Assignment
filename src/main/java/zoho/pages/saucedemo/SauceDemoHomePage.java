package zoho.pages.saucedemo;

import zoho.managers.WebDriverManager;

import java.util.TreeMap;

public class SauceDemoHomePage {


    WebDriverManager app;

    public SauceDemoHomePage(WebDriverManager app) {
        this.app=app;
    }

    public void sortProducts(String criteria){
        app.clickDropdown(criteria);
        app.log("Sorted by "+criteria);
    }

    public void clickLastitesms(int NoOfitems) {
        app.selectClickElementFromList(NoOfitems);
        app.log("Added cheap item last "+NoOfitems);
    }

    public void clickCart() {
        app.click("shoppingCart_xp");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.isElementPresent("cartPageHeader_xp");
        app.log("page topic : YOUR CART");
    }
}
