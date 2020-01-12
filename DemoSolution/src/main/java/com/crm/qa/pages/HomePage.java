package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//a[contains(@href,'contacts')]")
	WebElement lnkContacts;
	
	@FindBy(xpath = "//a[contains(@href,'deals')]")
	WebElement lnkDeals;
	
	@FindBy(xpath = "//a[contains(@href,'companies')]")
	WebElement lnkCompanies;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleHomePage() {
		return driver.getTitle();
	}
	
	public Contacts clickOnContactLink() {
		try
		{
		lnkContacts.click();
		return new Contacts();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
		

}
