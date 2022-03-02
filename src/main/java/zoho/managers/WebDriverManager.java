package zoho.managers;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebDriverManager {
	
	
	WebDriver driver;
	ExtentTest test;
	Properties prop;
	SoftAssert softAssert;

	public WebDriverManager() {
		// init the properties file
		try {
			prop=new Properties();
			//System.out.println(System.getProperty("user.dir"));
			String path = System.getProperty("user.dir")+"/src/test/resources/project.properties";
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		softAssert = new SoftAssert();
	}
	
   	public void openBrowser(String browser) {
        log("Open browser "+ browser);
        
        
        if(getProperty("grid_run").equals("Y")) {
        	// run on grid
        	DesiredCapabilities cap=null;
        	
			if(browser.equals("Mozilla")){
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				
			}else if(browser.equals("Chrome")){
				 cap = DesiredCapabilities.chrome();
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
        }else {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/linux/chromedriver");
			if(browser.equals("Mozilla")) {
				driver  = new FirefoxDriver();
			}else if(browser.equals("Chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("--disable-notifications");
				driver  = new ChromeDriver(options);
			}else if(browser.equals("Edge")) {
				driver  = new EdgeDriver();
			}
        }
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void navigate(String urlKey) {
		log("Navigating to "+getProperty(urlKey) );
		driver.get(getProperty(urlKey));
	}
	
	public void click(String locatorKey) {// assuming that locator is xpath
		log("Clicking on "+locatorKey );
		findElement(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {
		log("Typing in "+locatorKey );
		findElement(locatorKey).sendKeys(data);
	}
	
	
	public WebElement findElement(String locatorKey) {
		By locator = getLocator(locatorKey);
		WebElement e = null;
		try {
		  // present and visible
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		  e = driver.findElement(locator);
		}catch(Exception ex) {
			// report failure
			logFailure("Object not found "+ locatorKey,true);
		}
		return e;
	}
	
	public By getLocator(String locatorKey) {
		
		if(locatorKey.endsWith("_id"))
			return By.id(getProperty(locatorKey)); // By.id("login_id")
		else if(locatorKey.endsWith("_name"))
			return By.name(getProperty(locatorKey));
		else if(locatorKey.endsWith("_xp"))
			return By.xpath(getProperty(locatorKey));
		else 
			return By.cssSelector(getProperty(locatorKey));
	}
	
	/********************Validation Functions***************************/
	public boolean verifyTitle(String expectedTitleKey) {
		String expectedTitle = getProperty(expectedTitleKey);
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			return true;
		else
			return false;
	}
	// presence and visibility
	public boolean isElementPresent(String locatorKey) {
		By locator = getLocator(locatorKey);
		
		try {
		  // present and visible
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	
	/*************Utility Functions******************/
	
	public void init(ExtentTest test) {
    	this.test=test;
    }
    
    public String getProperty(String key) {
    	return prop.getProperty(key);
    }
    
    public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
    
    public void logFailure(String msg, boolean stopExecution) {
    	System.out.println("FAILURE---- "+ msg);
    	// screenshot of the page and embedd in reports
    	// fail in extent reports
    	test.log(Status.FAIL, msg);
    	// fail in testng-cucumber
    //	Assert.fail(msg);// hard assertion
    	softAssert.fail(msg);
    	
    	if(stopExecution)
    		softAssert.assertAll();
    }


	public void quit() {
		
		if(driver !=null)
			driver.quit();
		
		if(softAssert!=null)
			softAssert.assertAll();
		
	}
	
	public int getLeadRowNumberWithCellData(String leadName) {
		List<WebElement> names = driver.findElements(getLocator("leadnames_css"));
		for(int i=0;i<names.size();i++) {
			if(leadName.equalsIgnoreCase(names.get(i).getText()))
				return (i+1);
		}
		
		return -1;// not found
	}

	public void selectLeadCheckBox(int rowNum) {
		driver.findElement(By.cssSelector("lyte-exptable-tr:nth-child("+rowNum+") > lyte-exptable-td:nth-child(2) label")).click();
		
	}
	

	
	public void scrollDownWindow() throws InterruptedException {
		//driver = new ChromeDriver();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,250)");
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Expand to read the full story')]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(500);*/

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	
	
	public void selectAndClickElementFromList(int listNo){
		List<WebElement> elm = driver.findElements(getLocator("readMore_xp"));
		for(int i=0;i<elm.size();i++) {
			elm.get(listNo).
				click();
		}
		elm.get(listNo).click();
	}

	public void clickAllSection(String selector) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String searchText = selector;
		WebElement dropdown = driver.findElement(By.xpath("//li[@class='main-menu__item is-hide-link']/child::span"));
		//WebElement dropdown = app.findElement("allsectionMenu_XP");
		dropdown.click();
		List<WebElement> options = driver.findElement(By.xpath("//*[@class='layout-container layout-container--']/child::div[2]/descendant::*[@class='modal__content__col modal__content__col--one'][1]/descendant::ul[@class='hamburger-menu']")).findElements(By.tagName("li"));

		Iterator<WebElement> itr = options.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

		for (WebElement option : options)
		{
			if (option.getText().equals(searchText))
			{
				option.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
			}
		}
	}

	public void clickMenuItem(String country) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String searchText = country;
		WebElement dropdown = driver.findElement(By.xpath("//ul[@data-region='header_nav']"));
		//WebElement dropdown = app.findElement("allsectionMenu_XP");
		//dropdown.click();
		List<WebElement> options = driver.findElement(By.xpath("//ul[@data-region='header_nav']")).findElements(By.tagName("li"));

		Iterator<WebElement> itr = options.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

		for (WebElement option : options)
		{
			if (option.getText().equals(searchText))
			{
				option.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
			}
		}
	}

	public void clickDropdown(String selector){
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
		dropdown.selectByVisibleText(selector);
	}

	public void selectClickElementFromList(int listNo){
		List<WebElement> elm = driver.findElements(getLocator("addToCart_xp"));
		int elmSize = elm.size();
		for(int j=listNo;j>0;j--) {
			elm.get(elmSize-(j)).click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
