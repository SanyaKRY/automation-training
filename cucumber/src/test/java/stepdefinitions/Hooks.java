package stepdefinitions;

import driver.DriverSingleton;
import informationbetweenstepsdefinitions.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  
  TestContext context;
	
  public Hooks(TestContext context) {
	this.context = context;
  }
	
  @Before()
  public void beforeScenario() {
	context.driver = DriverSingleton.getDriver();
	context.driver.manage().window().maximize();
  }
	 
  @After()
  public void afterScenario() {
	DriverSingleton.closeDriver();
  }

}
