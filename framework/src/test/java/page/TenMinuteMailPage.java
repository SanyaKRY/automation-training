package page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

import util.WaitingSomeConditions;

public class TenMinuteMailPage extends AbstractPage {
	
  private final String TEN_MINUTE_EMAIL_PAGE_URL = "https://10minutemail.net/";
  
  private final Logger logger = LogManager.getRootLogger();
		
  @FindBy(id = "fe_text")
  private WebElement temporaryMail;
	  
  @FindBy(xpath="//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
  private WebElement newMessage;
		  
  @FindBy(xpath="//*[@id='tab1']//table[@class='quote']//td/h3")
  private List<WebElement> finalCostFromLetter;
		
  public TenMinuteMailPage(WebDriver driver) {
	super(driver);
  }

  public AbstractPage openPage() {
	driver.get(TEN_MINUTE_EMAIL_PAGE_URL);
	return this;
  }
		  
  public TenMinuteMailPage openTemporaryMailWindow() {
	driver.switchTo().newWindow(WindowType.TAB);
	openPage();
	return this;
  }
		  
  public String getTenMinuteMailText() {
	logger.info("temporary mail is"+temporaryMail.getAttribute("value"));
	return temporaryMail.getAttribute("value");	        
  }
			  
  public String openNewMessageAndGetFinalCostFromLetter(){
	WaitingSomeConditions.waitForElementVisibilityOf(driver, newMessage, 180).click();	
	logger.info("total cost from letter is received");
	return finalCostFromLetter.get(1).getText();
  }		  
}
