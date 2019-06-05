package page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.WaitingSomeConditions;

public class TenMinuteMailPage extends AbstractPage {	
	
	private final String TEN_MINUTE_EMAIL_PAGE_URL = "https://10minutemail.net/";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(id="fe_text")
	 private WebElement temporaryMail;
	
	@FindBy(xpath="//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
	 private WebElement newMessageFromGoogleCloudPlatformPriceEstimate;
	
	@FindBy(xpath="//*[@id='tab1']//table[@class='quote']//td/h3")
	 private List<WebElement> finalCostFromLetter;
	
	public TenMinuteMailPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public TenMinuteMailPage openPage() {
		driver.navigate().to(TEN_MINUTE_EMAIL_PAGE_URL);
		return this;		
	}
	
	public TenMinuteMailPage openTemporaryMailWindow() {
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", "https://10minutemail.net/");  
    	logger.info("the second window is open with temporary mail");
    	return this;
    }
	
	public String getTenMinuteMailText() {
		logger.info("temporary mail: "+temporaryMail.getAttribute("value"));
		return temporaryMail.getAttribute("value");	        
	 }
	
	public String getFinalCostFromLetter(){
		WaitingSomeConditions.waitForElementVisibilityOf(driver, newMessageFromGoogleCloudPlatformPriceEstimate).click();
		logger.info("letter opened, final Cost From Message: "+finalCostFromLetter.get(1).getText());
	    return finalCostFromLetter.get(1).getText();
	}

}
