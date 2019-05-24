package i_can_win.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PastebinPage extends AbstractPage {	

    public PastebinPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(id="paste_code")
    private WebElement code;

    @FindBy(name="paste_expire_date")
    private WebElement pasteExpiration;

    @FindBy(xpath="//*[@name='paste_name' and @class='post_input']")
    private WebElement pasteTitle;

    @FindBy(id="submit")
    private WebElement createNewPasteButton;    
	
	private static final String PASTEBIN_MAIN_PAGE_URL="https://pastebin.com";
	
	public PastebinPage openPage() {
        driver.get(PASTEBIN_MAIN_PAGE_URL);
        return this;
    }
	
	public PastebinPage inputCode(String paste) {
		code.sendKeys(paste);
        return this;
    }
		
	public PastebinPage selectExpiration(String expiration) {
		new Select(pasteExpiration).selectByVisibleText(expiration);
		return this;
	}
	
	public PastebinPage inputTitle(String title) {
		pasteTitle.sendKeys(title);
        return this;
    }
	
	public SuccessfullyPostedPastebinPage pushCreateNewPasteButton() {
		createNewPasteButton.click();
        return new SuccessfullyPostedPastebinPage(driver);
    }
	
}
