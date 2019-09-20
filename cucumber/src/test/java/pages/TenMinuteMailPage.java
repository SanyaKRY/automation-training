package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class TenMinuteMailPage extends AbstractPage {
	
  private final String TEN_MINUTE_EMAIL_PAGE_URL = "https://10minutemail.net/";
  private final Logger logger = LogManager.getRootLogger();
	
  @FindBy(id = "fe_text")
  private WebElement temporaryMail;
		
  @FindBy(xpath="//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
  private WebElement newMessageFromGoogleCloudPlatformPriceEstimate;
		
  @FindBy(xpath="//*[@id='tab1']//table[@class='quote']//td/h3")
  private List<WebElement> finalCostFromLetter;
		 
  public TenMinuteMailPage(WebDriver driver) {
	super(driver);
  }

  @Override
  protected AbstractPage openPage() {
	driver.get(TEN_MINUTE_EMAIL_PAGE_URL);
	return this;
  }
	
  public TenMinuteMailPage openTemporaryMailWindow() {
	((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", "https://10minutemail.net/");
	logger.info("the window with temporary mail is open");
	return this;
  }
	  
  public String getTenMinuteMailText() {
	logger.info("temporary mail is " + temporaryMail.getAttribute("value"));
	return temporaryMail.getAttribute("value");	        
  }
	  
  public TenMinuteMailPage openNewMessageFromGoogleCloudPlatformPriceEstimate(){
	new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOf(newMessageFromGoogleCloudPlatformPriceEstimate)).click();
	logger.info("the letter is open");
	return this;
  }
	  
  public String getFinalCostFromLetter(){
	logger.info("final cost received");
	return finalCostFromLetter.get(1).getText();
  }

}
