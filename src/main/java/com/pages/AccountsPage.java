package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	
	private WebDriver driver;
	private By accountSection = By.cssSelector("div.my-account-dashboard__gridwrapper div");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getAccountsectionCount()
	{
		return driver.findElements(accountSection).size();
	}
	
	public int getAccountSectionCount()
	{
		return driver.findElements(accountSection).size();
	}
	
	
	public List<String> getAccountSectionList()
	{
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSection);
		for (WebElement e : accountsHeaderList)
		{
			String text = e.getText();
			
			accountsList.add(text);
		}
		return accountsList;
	}
}
