package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public HomePageTest()
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
	    homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	    cartPage = new CartPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
	 String homePage_title = homePage.homePageTitle();
	 Assert.assertEquals(homePage_title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","HomePage title not Matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
	Assert.assertTrue(homePage.verifyCorrectUserName()); 
	}
	
	
	@Test(priority=3)
	public void navigateToCartPageTest()
	{
	cartPage = homePage.clickOnCart();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
