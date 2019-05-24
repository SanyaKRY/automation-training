package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hardcore.WaitingSomeConditions;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

public class TenMinuteMailPage extends AbstractPage {

	public TenMinuteMailPage(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(id="copy-button")
	 private WebElement tenMinuteMailTextCopyButton;

	 @FindBy(xpath="//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
	 private WebElement newMessageFromGoogleCloudPlatformPriceEstimate;

	 @FindBy(xpath="//*[@id='tab1']//table[@class='quote']//td/h3")
	 private List<WebElement> finalCostFromMessage;
	 
	 public TenMinuteMailPage openTenMinuteMailPage(){			 
		 ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", "https://10minutemail.net/");
		 //WaitingSomeConditions.waitForJquery(driver);
	     return this;
	 }
	 
	 public String getTenMinuteMailText() {
		 return WaitingSomeConditions.waitForElementToBeClickable(driver, tenMinuteMailTextCopyButton)
				 .getAttribute("data-clipboard-text");	        
	 }
	 
	 public String getFinalCostFromMessage(){
		 WaitingSomeConditions.waitForElementToBeClickable(driver,newMessageFromGoogleCloudPlatformPriceEstimate).click();
	        return finalCostFromMessage.get(1).getText();
	    }

}
