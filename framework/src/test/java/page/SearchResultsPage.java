package page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();
  
  @FindBy(xpath="//*[@class='gsc-webResult gsc-result']//*//*[text()='Google Cloud Platform Pricing Calculator']")
  private List<WebElement> searchResultsForRequest;
	 
  public SearchResultsPage(WebDriver driver) {
	super(driver);
  }
		
  public SearchResultsPage goToPriceCalculatorPage(){
	searchResultsForRequest.get(0).click();
	logger.info("went to the first link");
    return this;
  }
}
