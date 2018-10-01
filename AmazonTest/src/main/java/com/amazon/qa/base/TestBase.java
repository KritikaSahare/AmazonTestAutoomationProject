package com.amazon.qa.base;
import java.io.FileInputStream;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.TestUtil;
import com.amazon.qa.util.WebEventListener;
public class TestBase {
//
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
		
		
		public TestBase()
		{
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("C:\\Users\\ShashiBhushan\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public static void initialization()
		{
	        String Browser_name =prop.getProperty("browser");
	        
	        if(Browser_name.equals("chrome"))
	        {
	        	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	        	driver = new ChromeDriver();
	        }
			if(Browser_name.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	        	driver = new FirefoxDriver();
			}
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		//	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
		
		
	}

