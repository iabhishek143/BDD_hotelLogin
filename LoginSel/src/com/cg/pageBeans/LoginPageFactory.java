package com.cg.pageBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	public LoginPageFactory(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Identify Elements
	@FindBy(name= "userName")
	@CacheLookup
	WebElement pfuserName;
	
	@FindBy(xpath=".//*[@id='mainCnt']/div/div[1]/form/table/tbody/tr[3]/td[2]/input")
	@CacheLookup
	WebElement pfuserPswd;
	
	@FindBy(xpath=".//*[@id='mainCnt']/div/div[1]/form/table/tbody/tr[4]/td[2]/input")
	@CacheLookup
	WebElement pflogin;
	
	@FindBy(id="userErrMsg")
	@CacheLookup
	WebElement pfuserNameErr;
	
	@FindBy(id="pwdErrMsg")
	@CacheLookup
	WebElement pfuserPswdErr;
	
	//Getters-Setters
	public WebElement getPfuserName() {
		return pfuserName;
	}

	public void setPfuserName(String suserName) {
		pfuserName.sendKeys(suserName);
	}

	public WebElement getPfuserPswd() {
		return pfuserPswd;
	}

	public void setPfuserPswd(String suserPswd) {
		pfuserPswd.sendKeys(suserPswd);
	}

	public void setPflogin() {
		pflogin.click();
	}

	public WebElement getPfuserNameErr() {
		return pfuserNameErr;
	}

	public void setPfuserNameErr(String suserNameErr) {
		pfuserNameErr.sendKeys(suserNameErr);
	}

	public WebElement getPfuserPswdErr() {
		return pfuserPswdErr;
	}

	public void setPfuserPswdErr(String suserPswdErr) {
		pfuserPswdErr.sendKeys(suserPswdErr);
	}	
	
}
