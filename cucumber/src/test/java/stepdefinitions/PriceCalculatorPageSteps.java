package stepdefinitions;

import informationbetweenstepsdefinitions.ScenarioContext;
import informationbetweenstepsdefinitions.TestContext;
import io.cucumber.java.en.When;
import model.ComputeEngineUser;
import pages.PriceCalculatorPage;
import service.JsonDataReader;

public class PriceCalculatorPageSteps {
	
  TestContext context;
  PriceCalculatorPage priceCalculatorPage ;
  ScenarioContext scenarioContext;
  
  public PriceCalculatorPageSteps(TestContext context) {
	this.context = context;
	priceCalculatorPage = context.priceCalculatorPage;
	scenarioContext = context.scenarioContext;
  }
	
  @When("^\\\"(.*)\\\" fills out the form$")
  public void customerFillsOutForm(String computeEngine){
	ComputeEngineUser computeEngineUser = new JsonDataReader().getComputeEngineUserByName(computeEngine);
	priceCalculatorPage.fillOutForm(computeEngineUser);
	priceCalculatorPage.pressAddToEstimateButton();
	String totalCostFromEstimate = priceCalculatorPage.getTotalCostFromEstimate();
	scenarioContext.setContext("totalCostFromEstimateKey", totalCostFromEstimate);
	priceCalculatorPage = priceCalculatorPage.pressEmailEstimateButton();
  }

}
