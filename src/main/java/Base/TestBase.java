package Base;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Keyword.Keyword;

public class TestBase
{

	private static final Logger logger = LogManager.getLogger(TestBase.class);

	Keyword keywd=new Keyword();
	@BeforeMethod
	public void setup() {

		keywd.launchBrowser("chrome");
		keywd.luanchUrl();
		logger.info("Browser initialized successfully");

	}

	@AfterMethod
	public void quitDriver() {

		logger.info("Quitting WebDriver");
		keywd.driver.quit();

	}
}
