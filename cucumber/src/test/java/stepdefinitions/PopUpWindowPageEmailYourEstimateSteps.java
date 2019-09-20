package stepdefinitions;

import org.openqa.selenium.WebDriver;

import informationbetweenstepsdefinitions.ScenarioContext;
import informationbetweenstepsdefinitions.TestContext;
import io.cucumber.java.en.And;
import pages.PopUpWindowPageEmailYourEstimate;

public class PopUpWindowPageEmailYourEstimateSteps {

  TestContext context;
  WebDriver driver;
  PopUpWindowPageEmailYourEstimate popUpWindowPageEmailYourEstimate ;
  ScenarioContext scenarioContext;
	
  public PopUpWindowPageEmailYourEstimateSteps(TestContext context) {
	this.context = context;
	driver = context.driver;
	popUpWindowPageEmailYourEstimate = context.popUpWindowPageEmailYourEstimate;
	scenarioContext = context.scenarioContext;
  }
	
  @And("^customer switches to the main window$")
  public void customerSwitchesToMainWindow() { 
	driver.switchTo().window((String)scenarioContext.getContext("mainWindowKey"));
  }

  @And("^customer fills in a email and sends email$")
  public void customerFillsInEmail(){	
	popUpWindowPageEmailYourEstimate = new PopUpWindowPageEmailYourEstimate(driver);
	popUpWindowPageEmailYourEstimate.switchToFrame().fillInEmailField((String)scenarioContext.getContext("temporaryMailKey"));
	popUpWindowPageEmailYourEstimate.pressSendEmailButton();	
  }
  
}
