package hardcore.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TenMinuteMailPage extends AbstractPage {
	
  private final String TEN_MINUTE_EMAIL_PAGE_URL = "https://10minutemail.net/";
	
  @FindBy(id="fe_text")
  private WebElement temporaryMail;
	
  @FindBy(xpath="//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
  private WebElement newMessageFromGoogleCloudPlatformPriceEstimate;
	
  @FindBy(xpath="//*[@id='tab1']//table[@class='quote']//td/h3")
  private List<WebElement> finalCostFromLetter;
	 
  private final By label10MinuteMail = By.xpath("//*[@id='header']//*[text()='10 Минутная Почта']");
	
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
    return this;
  }
	
  public String getTenMinuteMailText() {
	waitForPresenceOfElementLocated(driver, label10MinuteMail);
	return temporaryMail.getAttribute("value");	        
  }
	
  public String getFinalCostFromLetter(){
	//иногда приходится ждать очень долга письма, не знаю с чем это связано
	new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOf(newMessageFromGoogleCloudPlatformPriceEstimate)).click();
	return finalCostFromLetter.get(1).getText();
  }

}
