package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import driver.DriverSingleton;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
	
	protected WebDriver driver;
	
	@BeforeMethod()
	public void setUp() {
		driver = DriverSingleton.getDriver();
	}
	
	@AfterMethod()
	public void stopBrowser() {
		DriverSingleton.closeDriver();
	}

}
