package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_TIMEOUT_TIME = 20;
	public static long IMPLICIT_WAIT = 20;
	
	
	
	public static Object[][] getdata() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fr = new FileInputStream("D:\\JavaSelenium\\DemoSolution\\src\\main\\java\\com\\crm\\qa\\testdata\\Data.xlsx");
		
		Workbook book = WorkbookFactory.create(fr);
		
		Sheet Sheet = book.getSheet("Data");
		
		Object[][] data = new Object[Sheet.getLastRowNum()][Sheet.getRow(0).getLastCellNum()]; //[2][1]
		
		for (int i =0;i<Sheet.getLastRowNum();i++)
		{
			for(int j=0;j<Sheet.getRow(0).getLastCellNum();j++)
			{
				
				data[i][j] = Sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		
		return data;
		
	}
	
	
	

}
