package com.amazon.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class UserAccountPage extends TestBase {

	@FindBy(xpath="//h2[contains(text(),'Your Orders')]")
	WebElement yourOrders;
	
	@FindBy(xpath="//h2[contains(text(),'Login & security')]")
	WebElement Login_Security;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account')]")
	WebElement Your_Account;
	
	@FindBy(xpath="//img[@alt='Your Orders']")
	WebElement yourOrders_Logo;
	
	public UserAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateYourAccount_title()
	{
		return driver.getTitle();
	}
	
	public boolean validateyourOrders_Logo()
	{
	     return	yourOrders_Logo.isDisplayed();
	}
	
	public LoginAndSecurityPage validateLogin_Securitylink()
	{
		Login_Security.click();
		return new LoginAndSecurityPage();
	}
	
	public YourOrdersPage clickOnYourOrdersLink()
	{
		yourOrders.click();
		return new YourOrdersPage();
	}
	
	
}
