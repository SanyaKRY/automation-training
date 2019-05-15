package bring_it_on.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageCreatedPastebin extends AbstractPage {

    public PageCreatedPastebin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"selectable\"]/ol")
    private List<WebElement> codeElements;

    @FindBy(xpath="//*[@id='code_buttons']//a[text()='Bash']")
    private WebElement bashSymbol;

    public String validatePageTittle(){
        return driver.getTitle();
    }

    public boolean validatePageBash(){
        return bashSymbol.isDisplayed();
    }

    public String compareCode(){
        List<WebElement> elements = codeElements;

        String code = "";
        for (int i=0; i<elements.size();i++){
            code+=elements.get(i).getText();
        }
        return code.replaceAll("\\s+","");
    }
}
