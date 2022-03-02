package zoho.pages.cna;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import zoho.managers.WebDriverManager;

public class CnaNewsItemPage {

    WebDriverManager app;
    CnaNewsItemPage cnaNewsItemPage;

    public CnaNewsItemPage(WebDriverManager app) {
        this.app = app;
    }

    public void ValidateStoryOfHeadline(String headline) {
        WebElement headStory = app.findElement("headlineStory_xp");
        Assert.assertEquals(headStory.getText().trim().replaceAll("[-+.^:,']",""), headline, "Headline news is not matched");
    }

    public void scrolldown() throws InterruptedException {
       // JavascriptExecutor jse = (JavascriptExecutor)dr;
        //jse.executeScript("window.scrollBy(0,250)");
        //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        app.scrollDownWindow();
    }

    public void clickANewsItem(int newsItemNo) {
        app.selectAndClickElementFromList(newsItemNo-1);
    }

}
