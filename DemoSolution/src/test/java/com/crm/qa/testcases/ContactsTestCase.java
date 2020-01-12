package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsTestCase extends TestBase {
	LoginPage objlogin;
	HomePage objHomePage;
	Contacts objContactPage;
	
	
	public ContactsTestCase() {
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		Initialize();
		objlogin = new LoginPage();
		objHomePage = objlogin.Login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		objContactPage = objHomePage.clickOnContactLink();		
		
	}
	
	@DataProvider
	public Object[][] getTestData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Object[][] data=TestUtil.getdata();
		
		return data;
	}
	
	
	@Test (dataProvider = "getTestData")
	public void ValidateCreateNewContact(String FirstName, String LastName)
	{
		objContactPage.CreateNewContact(FirstName, LastName);
	}
	
	@AfterMethod
	public void cleanDown() {
		driver.quit();
	}
	
	

}
