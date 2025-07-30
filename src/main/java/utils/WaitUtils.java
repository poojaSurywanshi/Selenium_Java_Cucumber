package utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private static final Logger logger = LogManager.getLogger(WaitUtils.class);
 
    private static WebDriverWait wait = null;

	private WebDriver driver;

    public WaitUtils(WebDriver driver) {
    	this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   
	}

	
	public WebDriverWait getWait() {
        return wait;
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        logger.debug("Waiting for element to be visible: {}", element);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        logger.debug("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable: {}", element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        logger.debug("Waiting for element to be clickable: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForElementToBeInvisible(WebElement element) {
        logger.debug("Waiting for element to be invisible: {}", element);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitForElementToBeInvisible(By locator) {
        logger.debug("Waiting for element to be invisible: {}", locator);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    public void waitForFrameAndSwitchToIt(int frameIndex) {
        logger.debug("Waiting for frame at index {} and switching to it", frameIndex);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    public void waitForFrameAndSwitchToIt(String frameNameOrId) {
        logger.debug("Waiting for frame '{}' and switching to it", frameNameOrId);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
    }

    public void waitForFrameAndSwitchToIt(WebElement frameElement) {
        logger.debug("Waiting for frame element and switching to it");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public void waitForAjaxToComplete() {
        logger.debug("Waiting for AJAX calls to complete");
        wait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return jQuery.active == 0");
            } catch (Exception e) {
                // jQuery is not available
                return true;
            }
        });
    }

	public static void waitForPageToLoad() {
		// TODO Auto-generated method stub
		
	}
}
