package hurtmeplenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	
  protected WebDriver driver;
  protected final int WAIT_TIMEOUT_SECONDS = 20;
	
  protected AbstractPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(this.driver, this);
  }
	
  protected abstract AbstractPage openPage();
	
  protected WebElement waitForElementVisibilityOf(WebDriver driver, WebElement element) {
	return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
  }
	
  protected void waitForPresenceOfElementLocated(WebDriver driver, By by) {
	new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(by));
  }

}
