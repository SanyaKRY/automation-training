package i_can_win.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreatedPastebin extends AbstractPage {

    public PageCreatedPastebin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id='code_buttons']//a[text()='Bash']")
    private WebElement bashSymbol;

    public String validatePageTittle(){
        return driver.getTitle();
    }

    public boolean validatePageBash(){
        return bashSymbol.isDisplayed();
    }
}
