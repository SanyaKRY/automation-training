package bring_it_on.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageCreatePastebin extends AbstractPage {

    public PageCreatePastebin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private static final String PASTEBIN_MAIN_PAGE_URL="https://pastebin.com";

    @FindBy(id="paste_code")
    private WebElement code;

    @FindBy(name="paste_format")
    private WebElement syntaxHighlighting;

    @FindBy(name="paste_expire_date")
    private WebElement pasteExpiration;

    @FindBy(xpath="//*[@name='paste_name' and @class='post_input']")
    private WebElement pasteTitle;

    @FindBy(id="submit")
    private WebElement createButton;

    public PageCreatePastebin openPage() {
        driver.get(PASTEBIN_MAIN_PAGE_URL);
        return this;
    }

    public PageCreatedPastebin fillOutForm(String paste, String syntax, String expiration, String title) {
        code.sendKeys(paste);
        new Select(syntaxHighlighting).selectByVisibleText(syntax);
        new Select(pasteExpiration).selectByVisibleText(expiration);
        pasteTitle.sendKeys(title);
        createButton.click();
        return new PageCreatedPastebin(driver);
    }
}
