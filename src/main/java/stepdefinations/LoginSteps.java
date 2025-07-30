package stepdefinations;
import org.testng.asserts.*;

import Base.TestBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Keyword.Keyword;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import utils.WaitUtils;

import org.testng.Assert;
import org.testng.TestNG;


public class LoginSteps {

	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	Keyword keywd;
	TestBase TestBase=new TestBase();
	LoginPage loginpage=new  LoginPage();


	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws InterruptedException {
		logger.info("Opened Login page");
		//keywd.luanchUrl();
		loginpage.click_Signin();
		keywd.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		loginpage.Enter_User_email(username);
		keywd.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@And( "click on the next button")
	public void click_on_the_next_button() throws InterruptedException{
		loginpage.click_Next();
		keywd.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info("Verifying error message for invalid email");
	}
	@Then("a validation message should be shown")
	public void a_validation_message_should_be_shown()
	{		
		loginpage.isErrorMessageDisplayed();
	        //Assert.assertEquals("Error message is not displayed", loginpage.isErrorMessageDisplayed());
}
	
	
	@Given("the user is on the login page1")
	public void the_user_is_on_the_login_page1() throws InterruptedException {
		logger.info("Opened Login page");
		//keywd.luanchUrl();
		loginpage.click_Signin();
		keywd.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@When("user enters username {string} and password1 {string}")
	public void user_enters_username_and_password1(String username, String password) throws InterruptedException {
		loginpage.Enter_User_email(username);
		keywd.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@And("click on next button")
	public void click_on_next_button() throws InterruptedException{
		loginpage.click_Next();
		keywd.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info("Verifying error message for invalid email");
		loginpage.Couldnt_SignIn();
	}
	
	 @Then("Enter password {string} and click on login")
	 public void Enter_password_and_click_on_login(String pasword) {
		 if(loginpage.Couldnt_SignIn()==true) {
			 
		 }else {
		 loginpage.passwordInput(pasword);
		 }
	 }
	
	
	
	
//    
}