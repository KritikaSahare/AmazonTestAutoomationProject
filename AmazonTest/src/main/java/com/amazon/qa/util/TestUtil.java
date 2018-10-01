package com.amazon.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amazon.qa.base.TestBase;

public class TestUtil extends TestBase {
public static long page_load_timeout=20;
public static long implicit_wait=10;
public static String TESTDATA_SHEET_PATH ="C:\\Users\\ShashiBhushan\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\RegistrationTestData.xlsx ";
public static Workbook book;
public static Sheet sheet;

         public void switchToFrame()
       {
          driver.switchTo().frame("mainpanel");
       }

     public static void mouseHoverOnElement(WebElement element)
        {
             Actions action = new Actions(driver);
             action.moveToElement(element).build().perform();
         }

     public static void takeScreenshotAtEndOfTest() throws IOException
     {
    	 File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 String currentDir = System.getProperty("user.dir");
    	 FileUtils.copyFile(srcFile, new File(currentDir +"/screenshots/" + System.currentTimeMillis()+".png"));
     }



public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException{
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;



}
}