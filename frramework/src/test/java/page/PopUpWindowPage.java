package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

  @Override
  public PopUpWindowPage openPage() {
	return this;		
  }

  public PopUpWindowPage fillInEmailField(String email) {	
	WaitingSomeConditions.waitForElementVisibilityOf(driver,emailField).click();
	emailField.sendKeys(email);
    logger.info("the email is entered");
	return this;
  }
  
  public PopUpWindowPage PressSendEmailButton() {			
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
	    logger.info("the letter is sent");
		return this;
	  }
  
}
