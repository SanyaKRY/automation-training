package icanwin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PastebinPage extends AbstractPage {
	
  private static final String PASTEBIN_MAIN_PAGE_URL = "https://pastebin.com";
	
  public PastebinPage(WebDriver driver) {
    super(driver);
  }
    
  public PastebinPage openPage() {
    driver.get(PASTEBIN_MAIN_PAGE_URL);
    return this;
  }
	
  @FindBy(id="paste_code")
  private WebElement code;

  @FindBy(name="paste_expire_date")
  private WebElement pasteExpiration;

  @FindBy(xpath="//*[@name='paste_name' and @class='post_input']")
  private WebElement pasteTitle;

  @FindBy(id="submit")
  private WebElement createNewPasteButton;  
    
  public PastebinPage fillOutForm(String paste, String expiration, String title) {
	code.sendKeys(paste);
	new Select(pasteExpiration).selectByVisibleText(expiration);
	pasteTitle.sendKeys(title);
	createNewPasteButton.click();
	return this;
  }

}
