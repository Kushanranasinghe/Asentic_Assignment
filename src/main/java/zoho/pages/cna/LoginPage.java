package zoho.pages.cna;

import zoho.managers.WebDriverManager;

public class  LoginPage {

    WebDriverManager app;

    public LoginPage(WebDriverManager app) {
        this.app=app;
    }


    public void doLogin() {
        app.log("Trying to login into Zoho");
        app.type("username_id", app.getProperty("userid"));
        app.click("nextbutton_xp");
        app.type("password_name",app.getProperty("pass"));
        app.click("nextbutton_xp");
        app.click("crm_xp");

    }

}
