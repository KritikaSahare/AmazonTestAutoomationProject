package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactor or Object Repository
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(id="continue")
	WebElement Continue;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(id="signInSubmit")
	WebElement LoginBtn;
	
	@FindBy(id="createAccountSubmit")
	WebElement Create_Amazon_account; 
	
	@FindBy(xpath="//a[@class='a-link-nav-icon']")
	WebElement Amazon_Logo;
	
	@FindBy(xpath="//span[@class='a-expander-prompt']")
	WebElement Need_Help;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginpageTitle()
	{
		return driver.getTitle();
		
	}
	
	public HomePage login(String email,String password)
	{
		Email.sendKeys(email);
		Continue.click();
		Password.sendKeys(password);
		LoginBtn.click();
		return new HomePage();
	}
	
	public boolean validateAmazonlogo()
	{
		return Amazon_Logo.isDisplayed();
	}

}
