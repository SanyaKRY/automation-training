package bringiton.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAfterCreationOfPastebin extends AbstractPage {
	
  public PageAfterCreationOfPastebin openPage() {
    return this;
  }
	
  public PageAfterCreationOfPastebin(WebDriver driver) {
    super(driver);
  }
	
  @FindBy(xpath="//*[@id='selectable']/ol")
  private List<WebElement> codeElements;

  @FindBy(xpath="//*[@id='code_buttons']//a[text()='Bash']")
  private WebElement bashSymbol;
    
  public String validatePageTittle() {
    return driver.getTitle();
  }

  public boolean validatePageBash() {
    return bashSymbol.isDisplayed();
  }

  public String checkCode() {    	
    List<WebElement> elements = codeElements;
    String code = "";
    for (int i = 0; i < elements.size(); i++) {        	
      code += elements.get(i).getText();
      System.out.println(elements.get(i).getText());
    }        
    return code.replaceAll("\\s+","");    
  }

}
