package StepDefinations;

import org.junit.Assert;

import com.pages.Login;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private Login login = new Login(DriverFactory.getDriver());
	private static String title;
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   DriverFactory.getDriver().get("https://www.newlook.com/uk/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = login.getLoginPageTitle();
		   System.out.println("Login page title: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		   Assert.assertTrue(title.contains(expectedTitle));
	   
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	   login.isForgotPwdlinkExist();
	}


	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   login.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	   login.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button()  {
	   login.ClickLogin();
	}
	
	@Then("user gets the title of the Home page")
	public void users_get_the_title_of_the_Home_page() {
	   title = login.getLoginPageTitle();
	   System.out.println("Title of home page:" + title);
}
}
