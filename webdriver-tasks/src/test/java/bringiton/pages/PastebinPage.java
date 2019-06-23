package bringiton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PastebinPage extends AbstractPage {
	
  private static final String PASTEBIN_MAIN_PAGE_URL = "https://pastebin.com";
	
  public PastebinPage openPage() {
    driver.get(PASTEBIN_MAIN_PAGE_URL);
    return this;
  }
	
  public PastebinPage(WebDriver driver) {
    super(driver);
  }
	
  @FindBy(id="paste_code")
  private WebElement code;
	
  @FindBy(name="paste_format")
  private WebElement syntaxHighlighting;

  @FindBy(name="paste_expire_date")
  private WebElement pasteExpiration;

  @FindBy(xpath="//*[@name='paste_name' and @class='post_input']")
  private WebElement pasteTitle;

  @FindBy(id="submit")
  private WebElement createNewPasteButton; 
    
  public PageAfterCreationOfPastebin fillOutForm(String paste, String syntax, String expiration, String title) {
    code.sendKeys(paste);
	new Select(syntaxHighlighting).selectByVisibleText(syntax);
	new Select(pasteExpiration).selectByVisibleText(expiration);		
	pasteTitle.sendKeys(title);
	createNewPasteButton.click();
	return new PageAfterCreationOfPastebin(driver);
  }

}
