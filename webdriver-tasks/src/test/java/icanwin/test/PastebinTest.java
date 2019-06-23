package icanwin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import icanwin.pages.PastebinPage;

public class PastebinTest {
	
  protected WebDriver driver;
  protected static final String PASTE = "Hello from WebDriver";
  protected static final String EXPIRATION = "10 Minutes";
  protected static final String TITLE = "helloweb";
	
  @BeforeMethod
  public void SetUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();        
  }	
	
  @Test
  public void fillOutFormTest() {
	new PastebinPage(driver).openPage().fillOutForm(PASTE, EXPIRATION, TITLE);
  }
		
  @AfterMethod
  public void TernDown() {
	driver.quit();  
	driver = null;
  }

}
