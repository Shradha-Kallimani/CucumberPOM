package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver ;
	
	public static ThreadLocal<WebDriver> tlDriver = new  ThreadLocal<>(); 
	/*If you want that a variable should be accessed by same thread by which 
	it is created, we can use ThreadLocal variables. This class makes variables thread 
	safe. Each thread of same object will have separate copy of object variables*/
	
	public WebDriver init_driver(String browser)
	//This method is user to initialise the (threadlocal)webdriver on the basis of the given browser parameter
	//@param browser 
	//@return i will return tlDriver
	{
		System.out.println("browser value is:" + browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		
		else if (browser.equals("internet explorer"))
		{
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		}
		
		else {
			System.out.println("Please pass the correct browser value ");
		
	}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	
	}
	
	//This is used to get the driver with Threadlocal 
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
		
	}
	
	
	
	
	
	

}
