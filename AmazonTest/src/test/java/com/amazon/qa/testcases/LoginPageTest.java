package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void SetUp()
	{
		 initialization();
		 loginPage = new LoginPage();
		 homePage = new HomePage();
		 homePage.signInBtn.click();
	}
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginpageTitle();
		Assert.assertEquals("Amazon Sign In", title);
	}
	
	@Test
	public void amazonLogoTest()
	{
		boolean logo = loginPage.validateAmazonlogo();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
