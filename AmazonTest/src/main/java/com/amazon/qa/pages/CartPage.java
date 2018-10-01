package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CartPage extends TestBase  {

     @FindBy(xpath="//h1[contains(text(),'Your Shopping Cart is empty')]")	
     WebElement cartTextWithZeroItems;

     public CartPage()
      {
	  PageFactory.initElements(driver, this);
      }
  
  
  public boolean cartLabelwithZeroItems()
  {
	 return cartTextWithZeroItems.isDisplayed();
  }
	
}
