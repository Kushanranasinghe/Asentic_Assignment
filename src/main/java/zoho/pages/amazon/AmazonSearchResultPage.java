package zoho.pages.amazon;

import zoho.managers.WebDriverManager;

public class AmazonSearchResultPage {

    WebDriverManager app;

    public AmazonSearchResultPage(WebDriverManager app) {
        this.app=app;
    }

    public void IsItemDisplayed(String text) {
        app.findElement("SearchedList").getText().equalsIgnoreCase(text);
    }
}
