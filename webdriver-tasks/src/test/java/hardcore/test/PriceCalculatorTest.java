package hardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hardcore.pages.CloudGoogleMainPage;
import hardcore.pages.PriceCalculatorPage;
import hardcore.pages.TenMinuteMailPage;

public class PriceCalculatorTest {
	
    protected WebDriver driver;
	
	protected static final String NUMBER_OF_INSTANCES="4";
	protected static final String INSTANCES_FOR="";
	protected static final String OPERATING_SYSTEM="Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
	protected static final String VM_CLASS="Regular";
	protected static final String INSTANCE_TYPE="n1-standard-8";	
	protected static final String NUMBER_OF_GPUs="1";
	protected static final String GPU_TYPE="NVIDIA Tesla V100";
	protected static final String LOCAL_SSD="2x375 GB";
	protected static final String DATACENTER_LOCATION="Frankfurt";
	protected static final String COMMITED_USAGE="1 Year";
		
	@BeforeMethod
	public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
	
	@Test
	public void compareValueOfpriceFromLetterAndEstimate() {
			
		PriceCalculatorPage priceCalculatorPage = new CloudGoogleMainPage(driver)
		.openPage()
		.goToPriceCalculatorPage()
		.switchToFrame()
		.fillOutForm(NUMBER_OF_INSTANCES, INSTANCES_FOR, OPERATING_SYSTEM, VM_CLASS, 
        		INSTANCE_TYPE, NUMBER_OF_GPUs, GPU_TYPE, LOCAL_SSD, DATACENTER_LOCATION, COMMITED_USAGE);			
		String costFromEstimate = priceCalculatorPage.getTotalCostFromEstimate();
		String mainWindow = driver.getWindowHandle();		
		TenMinuteMailPage tenMinuteMailPage = new TenMinuteMailPage(driver).openTemporaryMailWindow();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
        }
		String temporaryMail = tenMinuteMailPage.getTenMinuteMailText();
		String secondWindow = driver.getWindowHandle();		
		driver.switchTo().window(mainWindow);
		priceCalculatorPage.switchToFrame().sendMessageToTenMinutesMail(temporaryMail);
		driver.switchTo().window(secondWindow);
		String finalCostFromLetter = tenMinuteMailPage.getFinalCostFromLetter();
		Assert.assertTrue(costFromEstimate.contains(finalCostFromLetter));
		
	}
	
	@AfterMethod
	public void TernDown(){
		driver.quit();  
		driver=null;
    }

}
