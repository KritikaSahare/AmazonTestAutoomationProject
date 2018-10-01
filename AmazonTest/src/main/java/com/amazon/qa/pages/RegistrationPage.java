package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import org.apache.log4j.Logger;
public class RegistrationPage extends TestBase{


	   @FindBy(name="customerName")
	   WebElement CustomerName;
	
	   @FindBy(id="ap_phone_number")
	   WebElement Mobile_Number;
	
	   @FindBy(id="ap_email")
	   WebElement Email;
	
	   @FindBy(id="ap_password")
	   WebElement Password;
	
	   @FindBy(id="continue")
	   WebElement ContinueBtn;
	
	   public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	   public String getRTitle()
	{
		return driver.getTitle();
	}
	
	   public void registerNewUser(String Customer_Name,String Mobile_No,String email,String password )
	   {   
		   
		   CustomerName.clear();
		   CustomerName.sendKeys(Customer_Name);
		   
		   Mobile_Number.clear();
		   Mobile_Number.sendKeys(Mobile_No);
		   
		   Email.clear();
		   Email.sendKeys(email);
		   
		   Password.clear();
		   Password.sendKeys(password);
		  
		   ContinueBtn.click();
		   
	   }
	
	
	
}
