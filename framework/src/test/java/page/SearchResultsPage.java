package page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();
  private final String SEARCH_RESULTS_PAGE_URL = "https://cloud.google.com/s/results/?q=Google+Cloud+Platform+Pricing+Calculator&p=%2F";
	  
  @FindBy(xpath="//*[@class='gsc-webResult gsc-result']//*//*[text()='Google Cloud Platform Pricing Calculator']")
  private List<WebElement> searchResultsForRequest;
	 
  public SearchResultsPage(WebDriver driver) {
	super(driver);
  }

  @Override
  public SearchResultsPage openPage() {
	driver.navigate().to(SEARCH_RESULTS_PAGE_URL);
	return this;		
  }
		
  public PriceCalculatorPage goToPriceCalculatorPage(){
	searchResultsForRequest.get(0).click();
	logger.info("went to the first link");
    return new PriceCalculatorPage(driver);
  }
}
