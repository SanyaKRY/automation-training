package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.WaitingSomeConditions;

public class PopUpWindowPageEmailYourEstimate extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();

  @FindBy(id = "idIframe")
  private WebElement frame;
	  
  @FindBy(id = "input_401")
  private WebElement emailField;
	  
  @FindBy(xpath = "//*[@id='dialogContent_407']//button[@aria-label='Send Email']")
  private WebElement sendEmailButton;  
	   
  private final By labelEmailYourEstimate = By.xpath("//*[@id='dialogContent_407']//*[text()='Email Your Estimate']");
	   
  public PopUpWindowPageEmailYourEstimate(WebDriver driver) {
	super(driver);
  }

  @Override
  protected AbstractPage openPage() {
	return this;
  }
  
  public PopUpWindowPageEmailYourEstimate fillInEmailField(String email) {		    
	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelEmailYourEstimate);
	emailField.click();
	emailField.clear(); 	
	emailField.sendKeys(email); 
	return this;
  }
	 
  public void pressSendEmailButton()  {		    
	logger.info("letter with final cost sent");
	sendEmailButton.click();
  }
	
  public PopUpWindowPageEmailYourEstimate switchToFrame() {
	new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	return this;
  } 

}
