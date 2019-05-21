package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	
	protected WebDriver driver;
	
	protected AbstractPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
