package Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;
import Keyword.Keyword;
import io.qameta.allure.Step;
import utils.WaitUtils;
public class LoginPage {

	WebDriverWait wait=new WebDriverWait(Keyword.driver, Duration.ofSeconds(10));

	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	WebDriver driver;
	public Keyword keyword;

	public LoginPage() {
		this.driver=keyword.driver;
		PageFactory.initElements(keyword.driver, this);
	}

	//public BasePage basePage=new BasePage(driver);
	//WaitUtils waitutils=new WaitUtils(driver);

	@FindBy(css="a[aria-label=\"Sign in\"]")
	public WebElement Sign_in;

	@FindBy(xpath="//input[@name='Passwd']")
	public WebElement passwordInput;

	@FindBy(css=".Ekjuhf.Jj6Lae")
	public WebElement errmsg;

	@FindBy(css="#identifierId")
	public WebElement inputemail;

	@FindBy(xpath="//span[normalize-space()='Next']")
	public WebElement emailNextButton;

	@FindBy(xpath="#//h1[@class=\"vAV9bf\"] ")
	public WebElement couldnit_signin;

	@FindBy(css="a[class='WpHeLc VfPpkd-mRLv6 VfPpkd-RLmnJb']")
	public WebElement try_again;

	public void Enter_User_email(String username) {
		logger.info("Enter Email");
		if (!username.isEmpty())
			inputemail.sendKeys(username);
	}
	public void click_Signin() {
		Sign_in.click();
	}

	public void click_Next() {
		logger.info("Clicking on Email Next button");
		emailNextButton.click();
	}

	@Step("Check if error message is displayed")
	public void Enter_Password(String password) {
		logger.info("Enter password");
		if (!password.isEmpty())
			passwordInput.sendKeys(password);
		//		 keyword.enterText(passwordInput,"passwrdgf");
		logger.info("Checking if error message is displayed");
	}


	public void isErrorMessageDisplayed()
	{		
		WebElement Erromsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Ekjuhf.Jj6Lae")));
		if(Erromsg.isDisplayed()) {
			System.out.println("Error Mssage is Displayed succesfully");
			logger.info("Error Mssage is Displayed succesfully");
		}else 
		{
			logger.info("❌ Error message element is not displayed. || And Couldnt Sign In Page Appears");
		}
	}
	
	public boolean Couldnt_SignIn(){
		WebElement couldntSignIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class=\"vAV9bf\"]")));
		if (couldntSignIn.isDisplayed()) {
			logger.info("Couldnt Sign In Page Appears");
		
		}else {
			keyword.driver.navigate().back();
		}
		return true;
}













}