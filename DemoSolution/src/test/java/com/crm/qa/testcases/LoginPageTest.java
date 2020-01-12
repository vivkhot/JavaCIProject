package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	
	LoginPage objloginpage = null;;
    HomePage objHomePage  ;
	
	public LoginPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialize();
		objloginpage = new LoginPage();
		 
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	@Test (priority = 1)
	public void ValidateTitle(){
		String RunTimeTitle = objloginpage.HomePageTitle();
		Assert.assertEquals(RunTimeTitle, "Free CRM #1 cloud software for any business large or small");
	}
	
	
	@Test (priority = 2)
	public void LoginTest() {
		objHomePage = objloginpage.Login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	

}
