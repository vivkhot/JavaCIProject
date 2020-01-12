package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Contacts extends TestBase {
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement btnNew;
	
	@FindBy(name="first_name")
	WebElement txtFirstName;
	
	@FindBy(name="last_name")
	WebElement txtLastName;
	
	@FindBy(xpath ="//button[contains(text(),'Save')]")
	WebElement btnSave;
	
	public Contacts(){
		PageFactory.initElements(driver, this);
	}
	
	public void CreateNewContact(String FN, String LN)
	{
	  btnNew.click();
	  txtFirstName.sendKeys(FN);
	  txtLastName.sendKeys(LN);
	  btnSave.click();
		
	}
	
	

}
