package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage objLoginPage;
	HomePage objHomePage;
	Contacts objContacts;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialize();
	//	objContacts = new Contacts();
		objLoginPage = new LoginPage();
		objHomePage = objLoginPage.Login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
	
/*	@Test(priority = 1)
	public void verifyHomePageTitile() {
		String title = objHomePage.getTitleHomePage();
		assertEquals(title, "Cogmento CRM");
	}*/
	
	@Test(priority = 2)
	public void NavigateToContactsPage() {
	    objContacts = objHomePage.clickOnContactLink();
	}
	

}
