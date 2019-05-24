package hurt_me_plenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hurt_me_plenty.pages.CloudGooglePage;
import hurt_me_plenty.pages.PriceCalculatorPage;

public class PriceCalculatorTest {
	private WebDriver driver;
	CloudGooglePage cloudGooglePage;
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
		.selectLocalSSD("2x375 GB")
		.selectDatacenterLocation("Frankfurt (europe-west3)")
		.selectCommitedUsage("1 Year")
		.pushAddToEstimate();		
	}	
	
	@Test
	public void checkValuesEstimateTest() {
		fillOutForm();
		Assert.assertTrue(priceCalculatorPage.checkValuesEstimate("Regular", "n1-standard-8", "Frankfurt", "2x375 GB", "1 Year"));
	}
	
	@Test
	public void checkTotalEstimateCostTest() {
		fillOutForm();
		Assert.assertTrue(priceCalculatorPage.checkTotalEstimateCost("USD 1,187.77 per 1 month"));
	}

	@AfterMethod
	public void TernDown(){
		driver.quit();  
		driver=null;
    } 
    
}
