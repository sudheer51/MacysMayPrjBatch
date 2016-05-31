package com.macys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	static Properties pro;

	
	public static String[][] readExcel(String fileName,String sheetName) throws BiffException, IOException
	{
		File f = new File(fileName);
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		
		//Declare an 2D array..
		String data[][] = new String[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				Cell cell = sheet.getCell(j,i);
				data[i][j] =cell.getContents();
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
		return data;
		
	}
	
	

	public static void unconditionalWait(long timeinmillis)
	{
		try{
			Thread.sleep(timeinmillis);
		}
		catch(InterruptedException e)
		{

		}
	}
	public static WebElement findWebElement(WebDriver driver,String elementRef,String value){

		WebElement e = null ;
		switch(elementRef)
		{
		case "cssSelector":
			e= driver.findElement(By.cssSelector(value));
			break;
		}
		return e;
	}
	public static void loadMacysProperties(String fileName) throws IOException
	{
		  // Specify the file location I used . operation here because 
		 //we have object repository inside project directory only
		  File src=new File(fileName);

		  // Create  FileInputStream object 
		  FileInputStream fis=new FileInputStream(src);

		  // Create Properties class object to read properties file
		   pro=new Properties();

		  // Load file so we can use into our script 
		  pro.load(fis);

		  System.out.println("Property class loaded");
	}
	public static String getPropertyValue(String keyValue)
	{
		return pro.getProperty(keyValue);
	}

}
