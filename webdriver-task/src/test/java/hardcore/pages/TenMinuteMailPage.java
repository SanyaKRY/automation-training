package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hardcore.WaitingSomeConditions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

public class TenMinuteMailPage extends AbstractPage {

	private final String TEN_MINUTE_EMAIL_PAGE_URL = "https://10minutemail.net/";
	
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
		driver.get(TEN_MINUTE_EMAIL_PAGE_URL);
		return this;		
	}
	
	public TenMinuteMailPage openTemporaryMailWindow() {
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", "https://10minutemail.net/");
    	return this;
    }
	
	public String getTenMinuteMailText() {
		return temporaryMail.getAttribute("value");	        
	 }
	
	public String getFinalCostFromLetter(){
		WaitingSomeConditions.waitForVisibilityOfElement(driver, newMessageFromGoogleCloudPlatformPriceEstimate).click();
	    return finalCostFromLetter.get(1).getText();
	}

}
