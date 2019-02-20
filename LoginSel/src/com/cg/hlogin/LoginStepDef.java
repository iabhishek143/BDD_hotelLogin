package com.cg.hlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.cg.pageBeans.LoginPageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {
	
	private WebDriver driver;
	private LoginPageFactory objlpg;
	
	@Before
	public void openBrowsser() {
		String strDriver= "D:\\Seleniums Lib\\ex\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", strDriver);
		driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objlpg = new LoginPageFactory(driver);

	driver.get("file:///D:/Seleniums%20Lib/ex/login.html");
	}
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
		openBrowsser();
	}

	@Then("^check the title of the page$")
	public void check_the_title_of_the_page() throws Throwable {
		if (driver.getTitle().equals("Hotel Login")) System.out.println("***Title Matched");
		else System.out.println("TestCase 1:\n****Title Not Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();
	}

	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		openBrowsser();
	}

	@When("^user leaves username blank$")
	public void user_leaves_username_blank() throws Throwable {
		objlpg.setPflogin();
	}

	@Then("^display error message showing empty username$")
	public void display_error_message_showing_empty_username() throws Throwable {
		Assert.assertEquals(objlpg.getPfuserNameErr().getText(), "* Please enter userName.");
		System.out.println("TestCase2:\n****"+objlpg.getPfuserNameErr().getText());
	}

	@When("^user leaves password blank$")
	public void user_leaves_password_blank() throws Throwable {
		objlpg.setPfuserName("capgemini");
		objlpg.setPflogin();
	}

	@Then("^display error message showing empty password$")
	public void display_error_message_showing_empty_password() throws Throwable {
		Assert.assertEquals(objlpg.getPfuserPswdErr().getText(), "* Please enter password.");
		System.out.println("TestCase 3:\n****"+objlpg.getPfuserPswdErr().getText());
	}

	@When("^user enters correct login credentials$")
	public void user_enters_correct_login_credentials() throws Throwable {
		objlpg.setPfuserName("capgemini");
		objlpg.setPfuserPswd("capg1234");
		objlpg.setPflogin();
	}

	@Then("^display success page$")
	public void display_success_page() throws Throwable {
		driver.navigate().to("file:///D:/Seleniums%20Lib/ex/hotelbooking.html");
		System.out.println("TestCase 4");
		driver.close();
	}
	@When("^user enter wrong login credentials$")
	public void user_enter_wrong_login_credentials() throws Throwable {
		objlpg.setPfuserName("abc");
		objlpg.setPfuserPswd("abc");
		objlpg.setPflogin();
	}

	@Then("^display error message showing wrong credentials$")
	public void display_error_message_showing_wrong_credentials() throws Throwable {
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("TestCase 5:\n******" + alertMessage);
	    driver.close();
	}
}