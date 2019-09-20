package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import informationbetweenstepsdefinitions.ScenarioContext;
import informationbetweenstepsdefinitions.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.TenMinuteMailPage;

public class TenMinuteMailPageSteps {
	
  TestContext context;
  WebDriver driver;
  TenMinuteMailPage tenMinuteMailPage;
  ScenarioContext scenarioContext;
	
  public TenMinuteMailPageSteps(TestContext context) {
	this.context = context;
	driver = context.driver;
	tenMinuteMailPage = context.tenMinuteMailPage;
	scenarioContext = context.scenarioContext;
  }	
  
  @And("^customer opens a second window and receives temporary mail$")
  public void customerOpensSecondWindow() { 
	String mainWindow = driver.getWindowHandle();	
	scenarioContext.setContext("mainWindowKey", mainWindow);
	tenMinuteMailPage = new TenMinuteMailPage(driver).openTemporaryMailWindow();
	for (String window : driver.getWindowHandles()) {
	  driver.switchTo().window(window);
    }	
	String temporaryMail = tenMinuteMailPage.getTenMinuteMailText();
	scenarioContext.setContext("temporaryMailKey", temporaryMail);
	String secondWindow = driver.getWindowHandle();
	scenarioContext.setContext("secondWindowKey", secondWindow);
  }
	
  @And("^customer switches to the temporary mail window and opens the letter$")
  public void customerSwitchesToTemporaryMailWindow(){	
	driver.switchTo().window((String)scenarioContext.getContext("secondWindowKey"));
	tenMinuteMailPage.openNewMessageFromGoogleCloudPlatformPriceEstimate();
  }	
	
  @Then("^compares cost from letter and estimate$")
  public void customerOpensLetter() { 
	String totalCostFromLetter = tenMinuteMailPage.getFinalCostFromLetter();
	String totalCostFromEstimate =(String)scenarioContext.getContext("totalCostFromEstimateKey");
	Assert.assertTrue(totalCostFromEstimate.contains(totalCostFromLetter));
  }

}
