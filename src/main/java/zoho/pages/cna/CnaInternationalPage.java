package zoho.pages.cna;

import org.testng.Assert;
import zoho.managers.WebDriverManager;

public class CnaInternationalPage {
    WebDriverManager app;

    public CnaInternationalPage(WebDriverManager app) {

        this.app = app;
    }

    public void load(String browser) { // open browser and navigate it to home page
        app.log("Trying to load home page after launching browser");
        app.openBrowser(browser);
        app.navigate("url2");
    }


    public void checkTheTemperature(String city, String temp) {
        Assert.assertEquals(app.findElement("city_temp_xp").getText(), temp, "City temperature is not matching");
    }

    public void checkTheCondition(String city, String condition) {
        Assert.assertEquals(app.findElement("city_condition_xp").getText(), condition, "City condition is not matching");
    }


}
