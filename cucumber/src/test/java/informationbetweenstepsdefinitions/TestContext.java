package informationbetweenstepsdefinitions;

import org.openqa.selenium.WebDriver;

import pages.CloudGoogleMainPage;
import pages.PopUpWindowPageEmailYourEstimate;
import pages.PriceCalculatorPage;
import pages.TenMinuteMailPage;

public class TestContext {

  public WebDriver driver;
  public CloudGoogleMainPage cloudGoogleMainPage;
  public PriceCalculatorPage priceCalculatorPage ;
  public PopUpWindowPageEmailYourEstimate popUpWindowPageEmailYourEstimate;
  public TenMinuteMailPage tenMinuteMailPage;
  public ScenarioContext scenarioContext = new ScenarioContext();

}
