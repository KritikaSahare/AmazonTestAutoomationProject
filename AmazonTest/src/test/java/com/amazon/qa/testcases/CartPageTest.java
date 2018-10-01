package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;



public class CartPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public CartPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	   {
		 initialization();
		 loginPage = new LoginPage();
		 homePage  = new HomePage();
		 cartPage  = new CartPage();
		 cartPage  = homePage.clickOnCart();
		}
	
	@Test
	public void verifyCartLabelwithZeroItems()
	{
	Assert.assertTrue(cartPage.cartLabelwithZeroItems(),"Cart Label is missing on the Cart Page");	
	}
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
}
