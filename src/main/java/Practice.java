import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.WaitUtils;

public class Practice {
public static void main(String[] args) {
	

	 WebDriverManager.chromedriver().setup();


	
		WebDriver driver =new ChromeDriver();
		driver.get("https://accounts.google.com/");
		//WaitUtils waitutil=new WaitUtils();
	
		WebElement InputEmail	=driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
		InputEmail.click();InputEmail.sendKeys(" ");
		

		WebElement emailNextButton	=driver.findElement(By.id("identifierNext"));
		emailNextButton.click();
		WebElement errormsg=driver.findElement(By.cssSelector(".Ekjuhf.Jj6Lae"));

		//waitutil.waitForElementToBeVisible(errormsg );
	}


}