package StepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.Login;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
	
	private Login login = new Login(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) 
	{	
	   List<Map<String,String>>credList=credTable.asMaps();
	  String username = credList.get(0).get("username");
	  String password = credList.get(0).get("password");
	  
	  DriverFactory.getDriver().get("https://www.newlook.com/uk/login");
	  accountsPage = login.doLogin(username, password); 
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	    String title = accountsPage.getAccountsPageTitle();
	    System.out.println("Title is :" + title);
	}

	@Then("user gets Accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) 
	{
	  List<String> expAccountSectionList = sectionTable.asList();
	  System.out.println("Expected section list:" + expAccountSectionList);
	  
	  List<String> actualSectionList = accountsPage.getAccountSectionList();
	  System.out.println("Actual Section list: " + actualSectionList);
	  
	  Assert.assertTrue(expAccountSectionList.containsAll(actualSectionList));
	}

	@Then("count section count should be {int}")
	public void count_section_count_should_be(Integer expectedSectionCount) 
	{
		
		Assert.assertTrue(accountsPage.getAccountsectionCount() == expectedSectionCount);
		
	}

}
