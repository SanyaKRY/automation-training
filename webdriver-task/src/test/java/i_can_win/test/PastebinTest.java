package i_can_win.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import i_can_win.pages.PastebinPage;
import i_can_win.pages.SuccessfullyPostedPastebinPage;

public class PastebinTest {
	
	private WebDriver driver;	
	SuccessfullyPostedPastebinPage successfullyPostedPastebinPage;
	
	@BeforeMethod
	public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();        
    }	
	
	public void fillOutForm() {	
		successfullyPostedPastebinPage = new PastebinPage(driver).openPage().inputCode("Hello from WebDriver")
		.selectExpiration("10 Minutes")
		.inputTitle("helloweb")
		.pushCreateNewPasteButton();
	}	
	
	@Test
	public void successfulCreationTest() {
		fillOutForm();
	}
	
	
	@AfterMethod
	public void TernDown(){
		driver.quit();  
		driver=null;
    } 

}


