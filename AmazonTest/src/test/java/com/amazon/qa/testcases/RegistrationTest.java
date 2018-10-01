package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.RegistrationPage;
import com.amazon.qa.util.TestUtil;

public class RegistrationTest extends TestBase {
	HomePage homePage;
	RegistrationPage registrationPage;
    String sheetName="Kritika";
	
	
	public RegistrationTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void SetUP() throws InterruptedException
	{
		initialization();
		homePage = new HomePage();
	    registrationPage = new RegistrationPage();
	    registrationPage = homePage.clickonstartHereLink();
	
	}
	
	@Test
	public void verifyTitleTest()
	{
	    String RegistrationPageTitle = registrationPage.getRTitle();
		Assert.assertEquals(RegistrationPageTitle, "Amazon Registration");
	}
	
	
	@DataProvider
	public  Object[][] getAmazonTestData()
	{
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(dataProvider="getAmazonTestData")
	public void validateNewCustomerRegistration(String Name,String Mobile_No,String Email,String Password)
	{
		registrationPage.registerNewUser(Name, Mobile_No, Email, Password);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
