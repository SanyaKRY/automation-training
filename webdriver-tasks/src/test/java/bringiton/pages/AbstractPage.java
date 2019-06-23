package bringiton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	
  protected WebDriver driver;
	
  protected AbstractPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
  }
	
  protected abstract AbstractPage openPage();

}
