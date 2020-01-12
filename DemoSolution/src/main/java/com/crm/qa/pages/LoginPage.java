package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	//Page factory - OR 

	@FindBy(name = "email")
	WebElement txtUsername;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//div[contains(@class,'submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement lnkForgotPassword;
	
	@FindBy(xpath = "//a[contains(@href,'https://ui.freecrm.com')]")
	WebElement btnLogIn;
	
	@FindBy(xpath ="//div[contains(text(),'Login')]")
	WebElement btnLoginForApplication;
	
	//Initialize WebElements 
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Methods to perform action
	
	
	public String HomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	public HomePage Login(String Username, String Password){
		
		btnLogIn.click();
		txtUsername.sendKeys(Username);
		txtPassword.sendKeys(Password);
		btnLoginForApplication.click();
		return new HomePage();
	}
	
	
}
