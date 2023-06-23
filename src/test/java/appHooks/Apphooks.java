package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Apphooks 
{
	private DriverFactory driverFactory ;
	private WebDriver driver;
	private ConfigReader cofigreader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty()
	{
		cofigreader = new ConfigReader();
		prop = cofigreader.init_prop();
		
	}
	
	@Before(order = 1 )
	 public void launchBrowser()
	 {
		String Browsername = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(Browsername);
	 }
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed()) // take screenshot
		{
			String scName= scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", scName);
		} 
	}
}
