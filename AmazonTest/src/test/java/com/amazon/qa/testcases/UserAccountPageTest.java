package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginAndSecurityPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.UserAccountPage;
import com.amazon.qa.pages.YourOrdersPage;
import com.amazon.qa.util.TestUtil;

public class UserAccountPageTest extends TestBase{
	UserAccountPage useraccountPage;
	HomePage homePage;
	LoginPage loginPage;
	LoginAndSecurityPage loginandsecurity;
	YourOrdersPage yourorder;
	
	public UserAccountPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	    homePage = new HomePage();
	    TestUtil.mouseHoverOnElement(homePage.signInBtn);
	    loginPage = new LoginPage();
	    homePage.signInBtn.click();
	    homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	    homePage.Hello_UserLink.click();
	    useraccountPage = new UserAccountPage();
	    
	    
	}
	
	@Test
	public void validateYourAccount_titleTest()
	{
     String title = useraccountPage.validateYourAccount_title();
     Assert.assertEquals(title, "Your Account");
	}
	
	
	@Test
	public void validateyourOrders_LogoTest()
	{
	boolean logoTest =useraccountPage.validateyourOrders_Logo();
	Assert.assertTrue(logoTest);
	}
	
	@Test
	public void validateLogin_SecuritylinkTest()
	{
		loginandsecurity=useraccountPage.validateLogin_Securitylink();
		
	}
	
	@Test
	public void clickOnYourOrdersLinkTest()
	{
		yourorder = useraccountPage.clickOnYourOrdersLink();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

}}
