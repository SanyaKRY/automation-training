package i_can_win.tests;

import i_can_win.pages.PageCreatePastebin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPastebin(){
        new PageCreatePastebin(driver).openPage().fillOutForm("Hello from WebDriver","10 Minutes","helloweb");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        driver=null;
    }
}
