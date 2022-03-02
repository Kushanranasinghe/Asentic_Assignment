package zoho.pages.saucedemo;

import org.openqa.selenium.WebElement;
import zoho.managers.WebDriverManager;

public class SauceDemoCartPage {


    WebDriverManager app;
    //private String itemRemoveBtn_xp="//div[@class = 'item_pricebar' and substring(div[@class = 'inventory_item_price'], 2) < 8]";

    public SauceDemoCartPage(WebDriverManager app) {
        this.app=app;
    }

    public void removeCheapset(String value) {
       // String xpath = String.format(itemRemoveBtn, value);
        app.click("itemRemoveBtn_xp");
        app.log("Removed the chapest item");
    }

    public void checkout() {
        app.click("checkout_xp");
    }

    public void fillPurchaseForm(String fname, String lname, String zip) {
        app.type("fname_xp",fname);
        app.type("lname_xp",lname);
        app.type("zipCode_xp",zip);
        app.click("continueBtn_xp");
        app.log("Checkout form is filled");
    }

    public void VerifySuccessOfCheckout() {
        app.isElementPresent("headerCeckoutOverviwPage_xp");
        app.log("Checkout overview is displayed");
    }

    public void completeProcess() {
        app.click("btnFinish_xp");
    }

    public void checkSuccessMessage(String message) {
        app.isElementPresent("lblThankForYourOrder");
        app.log("Checkout process completed");
        app.quit();
    }
}
