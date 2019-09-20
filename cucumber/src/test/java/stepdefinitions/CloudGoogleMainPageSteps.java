package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import informationbetweenstepsdefinitions.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CloudGoogleMainPage;

public class CloudGoogleMainPageSteps {
	
  TestContext context;
  CloudGoogleMainPage cloudGoogleMainPage;
  WebDriver driver;
	
  public CloudGoogleMainPageSteps(TestContext context) {
	this.context = context;
	driver = context.driver;
	cloudGoogleMainPage = context.cloudGoogleMainPage;
  }
		
  @Given("^customer is on cloudgooglecom page$")
  public void customerIsOnCloudgooglecomPage(){
	driver.get("https://cloud.google.com/");
  }
	
  @When("^customer presses on products and pricing dropdown boxes$")
  public void customerPressesOnProductsAndPricingDropdownBoxes(){
	cloudGoogleMainPage	= new CloudGoogleMainPage(driver);		
	cloudGoogleMainPage.pressToDropDownBoxesProductsAndPricing();
  }
	
  @And("^customer chooses calculators link$")
  public void customerChoosesCalculatorsLink(){
	context.priceCalculatorPage = cloudGoogleMainPage.goToCalculatorLink();
  }
	
  @Then("^Google Cloud Platform Pricing Calculator will open$")
  public void GoogleCloudPlatformPricingCalculatorWillOpen(){				
	Assert.assertTrue(
	    context.priceCalculatorPage
		.switchToFrame()
		.islabelGoogleCloudPlatformPricingCalculatorDisplayed());
  }

}
