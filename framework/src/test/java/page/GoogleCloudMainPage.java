package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudMainPage extends AbstractPage {
	
  private final String GOOGLE_CLOUD_MAIN_PAGE_URL = "https://cloud.google.com/";  
  
  private final String searchTag = "Google Cloud Platform Pricing Calculator";
  
  private final Logger logger = LogManager.getRootLogger();
	  
  @FindBy(xpath="//*[@id='searchbox']/input")
  private WebElement searchIcon;

  @FindBy(xpath="//*[@class='button button-white devsite-suggest-all-results']")
  private WebElement linkToShowSearchResults;
		
  public GoogleCloudMainPage(WebDriver driver) {
	super(driver);
  }

  public GoogleCloudMainPage openPage() {
    driver.get(GOOGLE_CLOUD_MAIN_PAGE_URL);
	logger.info("Google cloud page opened");
	return this;		
  }
		   
  public SearchResultsPage goToSearchResultsPage(){ 
    searchIcon.click(); 
    searchIcon.sendKeys(searchTag);
    linkToShowSearchResults.click();
    logger.info("search started");
    return new SearchResultsPage(driver);
  }
}
