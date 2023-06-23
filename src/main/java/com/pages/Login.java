package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Login {
	private WebDriver driver;
	// 1. By locators 
	
	
	private By email = By.id("j_username");
	private By password = By.id("j_password");
	private By SignInButton = By.xpath("//button[contains(text(),'Sign In')]");
	private By forgotPwd = By.xpath("//a[contains(text(),'Forgotten password?')]");
	
	//2. Constructor of the page class
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3. page actions: feature behaviour of the page 
	public String getLoginPageTitle() {
		return driver.getTitle();
		}
	// According to POM, we should not write assertions in page class
	//Assertion should be written in your test class or step definition class
	
	public boolean isForgotPwdlinkExist()
	{
		return driver.findElement(forgotPwd).isDisplayed();
		
	}
	
	public void enterUsername(String Username)
	{
		
		driver.findElement(email).sendKeys(Username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(623, 24)", "");
	
		driver.findElement(SignInButton).click();
		
	}

	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Login with cred: " + un + " and " +pwd);
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(623, 24)", "");
		WebElement button = driver.findElement(SignInButton);
		button.click();
		return new AccountsPage(driver);
	}


}

