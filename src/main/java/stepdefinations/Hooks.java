package stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import Keyword.Keyword;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static final Logger logger = LogManager.getLogger(Hooks.class);
	RemoteWebDriver driver;
	ThreadLocal<RemoteWebDriver> thread = new ThreadLocal<RemoteWebDriver>();
	Keyword keyword = new Keyword();
	@Before
	public void setUp() throws Exception {

		Keyword.launchBrowser("chrome");
		thread.set(driver);
		keyword.luanchUrl();
		logger.info("Launched QA env url");
	}

	@After
	public void tearDown() throws Exception {
		keyword.driver.quit();
		//thread.get().close();
		//thread.remove();
	}
}
