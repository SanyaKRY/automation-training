package i_can_win.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullyPostedPastebinPage extends AbstractPage {
	
	public SuccessfullyPostedPastebinPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(xpath="//*[@id='success']")
    private WebElement note;

}
