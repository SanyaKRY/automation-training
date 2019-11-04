package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.WaitingSomeConditions;

public class PopUpWindowPage extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();
	
  @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
  private WebElement emailField;
		
  @FindBy(xpath = "//*[@aria-label='Send Email']")
  private WebElement sendEmailButton;  
	
  public PopUpWindowPage(WebDriver driver) {
	super(driver);
  }
  
  private final By labelEmailYourEstimate = By.xpath("//*[text()='Email Your Estimate']");

  @Override
  public PopUpWindowPage openPage() {
	return this;		
  }

  public PopUpWindowPage fillInEmailField(String email) {
	WaitingSomeConditions.waitForElementVisibilityOf(driver,emailField).sendKeys(email);
	sendEmailButton.click();
    logger.info("the email is entered and sent");
	return this;
  }
    
}
