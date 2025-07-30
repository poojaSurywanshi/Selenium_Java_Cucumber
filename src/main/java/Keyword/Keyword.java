package Keyword;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.WaitUtils;


public class Keyword{
	
	  public static final Logger logger = LogManager.getLogger(Keyword.class);
		public static WebDriver driver;
		WebDriverWait wait=new WebDriverWait(driver, null);
	    public static final String Gmail_URL = "https://www.google.com/";

	    
	    
	    public static void launchBrowser(String browserType) {
	        logger.info("Creating WebDriver instance for browser: {}", browserType);
	        
	        switch (browserType.toLowerCase()) {
	            case "chrome":
	                
	                ChromeOptions chromeOptions = new ChromeOptions();
	                chromeOptions.addArguments("--start-maximized");
	                chromeOptions.addArguments("--disable-notifications");
	                driver = new ChromeDriver(chromeOptions);
	                break;
	                
	            case "firefox":
	                FirefoxOptions firefoxOptions = new FirefoxOptions();
	                firefoxOptions.addArguments("--start-maximized");
	                driver = new FirefoxDriver(firefoxOptions);
	                break;
	                
	            case "edge":
	                EdgeOptions edgeOptions = new EdgeOptions();
	                edgeOptions.addArguments("--start-maximized");
	                driver = new EdgeDriver(edgeOptions);
	                break;
	                
	            case "safari" :
	            	driver=new SafariDriver();
	   			 driver.manage().window().maximize();
	   			 break;
	            		
	            default:
	                logger.warn("Unsupported browser: {}. Defaulting to Chrome", browserType);
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;
	        }
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	        driver.manage().window().maximize();
	        
	        logger.info("WebDriver initialized successfully for browser: {}", browserType);
	    }

	    public static void luanchUrl() {
			driver.get(Gmail_URL);
		}
	    
	    public void enterText(String locator, String textToEnter) {
			driver.findElement(By.xpath(locator)).sendKeys(textToEnter);
		}
		
	    public WebElement waitForElementToBeVisible(WebElement element) {

			return wait.until(ExpectedConditions.visibilityOf(element));
		}
	    public void SendkeyMethod(String Locator,String input) {
			driver.findElement(By.cssSelector(Locator)).sendKeys(input);
		}


}



























