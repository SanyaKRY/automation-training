package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.WaitingSomeConditions;

public class PopUpWindowPage extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();
	
  @FindBy(id = "input_415")
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

  public PopUpWindowPage fillInEmailFieldAndPressSendEmailButton(String email) {	
	WaitingSomeConditions.waitForElementVisibilityOf(driver,emailField).click();
	emailField.sendKeys(email);
    sendEmailButton.click();
    logger.info("the letter is sent");
	return this;
  }
}
