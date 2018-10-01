package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;
import org.apache.log4j.Logger;
public class HomePage extends TestBase {

  @FindBy(xpath="//span[text()='Hello. Sign in']")
  @CacheLookup
  public  WebElement signInBtn;
  
  @FindBy(xpath="//span[text()='Hello, kritika']")
  @CacheLookup
  WebElement Username_label;
  
  @FindBy(id="twotabsearchtextbox")
  WebElement searchBox;
  
  @FindBy(xpath="//input[@value='Go']")
  WebElement SearchBox_Btn;
  
  @FindBy(xpath="//a[@id='nav-cart']")
  @CacheLookup
  WebElement cartLogo; 
  
	
  @FindBy(linkText="Start here.")
  @CacheLookup
  WebElement StartHereLink;
  
  @FindBy(xpath="//span[contains(text(),'Hello')]")
  public WebElement Hello_UserLink;	
		
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName()
	{
		return Username_label.isDisplayed();
		
	}
	
	public CartPage clickOnCart()
	{
		cartLogo.click();
		return new CartPage();
	}
	
	public SearchResultPage clickOnSearchBtn(String Search_Item)
	{
		searchBox.sendKeys(Search_Item);
		SearchBox_Btn.click();
		return new SearchResultPage();
		
	}
	public void moveCursorToSignIN()
	{
	  TestUtil.mouseHoverOnElement(StartHereLink);
	}
	
     public RegistrationPage clickonstartHereLink() throws InterruptedException {


    	 Thread.sleep(5000); 
		TestUtil.mouseHoverOnElement(signInBtn);
		StartHereLink.click();
		return new RegistrationPage() ;
	}
	
}

