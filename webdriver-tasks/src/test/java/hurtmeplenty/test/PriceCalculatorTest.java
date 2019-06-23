package hurtmeplenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hurtmeplenty.pages.CloudGoogleMainPage;
import hurtmeplenty.pages.PriceCalculatorPage;

public class PriceCalculatorTest {
	
  protected WebDriver driver;
	
  protected static final String NUMBER_OF_INSTANCES = "4";
  protected static final String INSTANCES_FOR = "";
  protected static final String OPERATING_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
  protected static final String VM_CLASS = "Regular";
  protected static final String INSTANCE_TYPE = "n1-standard-8";	
  protected static final String NUMBER_OF_GPUs = "1";
  protected static final String GPU_TYPE = "NVIDIA Tesla V100";
  protected static final String LOCAL_SSD = "2x375 GB";
  protected static final String DATACENTER_LOCATION = "Frankfurt";
  protected static final String COMMITED_USAGE = "1 Year";
	
  PriceCalculatorPage priceCalculatorPage;
	
  @BeforeClass
  public void SetUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();   
    priceCalculatorPage = new CloudGoogleMainPage(driver).openPage()
        .goToPriceCalculatorPage()
        .switchToFrame()
        .fillOutForm(NUMBER_OF_INSTANCES, INSTANCES_FOR, OPERATING_SYSTEM, VM_CLASS, INSTANCE_TYPE,
            NUMBER_OF_GPUs, GPU_TYPE, LOCAL_SSD, DATACENTER_LOCATION, COMMITED_USAGE);
  }
		
  @Test
  public void checkValuesFromEstimateTest() {
	Assert.assertTrue(priceCalculatorPage.comparesValuesFromEstimate(VM_CLASS, INSTANCE_TYPE, DATACENTER_LOCATION, LOCAL_SSD, COMMITED_USAGE));
  }
	
  @Test
  public void checkTotalCostFromEstimateTest() {
	Assert.assertTrue(priceCalculatorPage.comparesTotalCostFromEstimate("USD 1,187.77 per 1 month"));
  }

  @AfterClass
  public void TernDown(){
	driver.quit();  
	driver = null;
  }

}
