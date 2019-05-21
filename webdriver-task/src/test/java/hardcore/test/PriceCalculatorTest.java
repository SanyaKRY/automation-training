package hardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hardcore.pages.CloudGooglePage;
import hardcore.pages.PriceCalculatorPage;
import hardcore.pages.TenMinuteMailPage;

public class PriceCalculatorTest {
	private WebDriver driver;
	CloudGooglePage cloudGooglePage;
	TenMinuteMailPage tenMinuteMailPage;
	PriceCalculatorPage priceCalculatorPage;
	
	@BeforeMethod
	public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();        
    }
	
	public void fillOutForm() {
		priceCalculatorPage = new CloudGooglePage(driver).openPage().goToPriceCalculatorPage().switchToFrame()
		.pushComputeEngine()
		.pushNumberOfInstances("4")
		.pushInstancesFor()
		.selectOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
		.selectVMClass("Regular")
		.selectInstanceType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
		.pushAddGPUs()
		.selectNumberOfGPUs("1")
		.selectGPUType("NVIDIA Tesla V100")
		.selectLocalSSD("3x375 GB")
		.selectDatacenterLocation("Frankfurt (europe-west3)")
		.selectCommitedUsage("1 Year")
		.pushAddToEstimate();		
	}
	
	public void sendLetterToMail() {
		String mainWindow = driver.getWindowHandle();
		tenMinuteMailPage = new TenMinuteMailPage(driver).openTenMinuteMailPage();		
		for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }		
		String secondWindow = driver.getWindowHandle();		
		String temporaryMail = tenMinuteMailPage.getTenMinuteMailText();
		driver.switchTo().window(mainWindow);
		priceCalculatorPage.switchToFrame().sendMessageToTenMinutesMail(temporaryMail);
	}
	
	@Test
	public void test() {
		fillOutForm();	
		sendLetterToMail();
		String  price = priceCalculatorPage.getFinalCostFromEstimate();
		for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }				
		Assert.assertTrue(price.contains(tenMinuteMailPage.getFinalCostFromMessage()));
	}

	@AfterMethod
	public void TernDown(){
		driver.quit();  
		driver=null;
    } 
}
