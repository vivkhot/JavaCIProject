package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try
		{
			// Reading Config file
	    prop = new Properties();		
		FileInputStream ip = new FileInputStream("D:\\JavaSelenium\\DemoSolution\\src\\main\\java\\com\\crm\\qa\\config\\app.properties");
		//	FileReader fr =  new FileReader("config.properties"); //"D:/JavaSelenium/DemoSolution/src/main/java/com/crm/qa/config/config.propertise"
		//	File fr = TestBase.class.getResourceAsStream("/resources/app.properties");
		
			prop.load(ip);
			String name = "Chk";
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void Initialize () {
		
		String browser = prop.getProperty("BROWSER");
		
		if(browser.equals("Chrome"))		
		{
			System.setProperty("webdriver.chrome.driver","E:\\Drivers\\Chrome79\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
		
	}
	
	
	
    
	

}
