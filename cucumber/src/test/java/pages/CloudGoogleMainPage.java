package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.WaitingSomeConditions;

public class CloudGoogleMainPage extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();
  private final String CLOUD_GOOGLE_MAIN_PAGE_URL = "https://cloud.google.com/";
	
  @FindBy(xpath="//*[@track-name='products' and @track-type='globalNav']")
  private WebElement DropDownBoxproducts;

  @FindBy(xpath="//*[@track-name='pricing' and @track-type='globalNav']")
  private WebElement DropDownBoxpricing;

  @FindBy(xpath="//*[@href='https://cloud.google.com/products/calculator/' and @track-name='pricing']")
  private WebElement calculatorLink;
	
  public CloudGoogleMainPage(WebDriver driver) {
	super(driver);
  }
	
  public CloudGoogleMainPage pressToDropDownBoxesProductsAndPricing(){ 
	DropDownBoxproducts.click();
	DropDownBoxpricing.click();	
	logger.info("pressed to drop down boxes products and pricing");
	return this;
  }

  @Override
  protected AbstractPage openPage() {
	driver.get(CLOUD_GOOGLE_MAIN_PAGE_URL);
	return this;
  }
	
  public PriceCalculatorPage goToCalculatorLink(){ 
	WaitingSomeConditions.waitForElementVisibilityOf(driver, calculatorLink).click();
	logger.info("went to calculator link");
	return new PriceCalculatorPage(driver);
  }

}
