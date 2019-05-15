package hurt_me_plenty.tests;

import hurt_me_plenty.pages.CloudGooglePage;
import hurt_me_plenty.pages.PriceCalculatorPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PriceCalculatorTest {
    private WebDriver driver;
    PriceCalculatorPage priceCalculatorPage;

    @BeforeTest
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        priceCalculatorPage = new CloudGooglePage(driver).openPage().clickOnCalculatorLink().switchToFrame().fillOutForm();
    }

    @Test
    public void checkInstanceTypeEstimateTest (){
        Assert.assertTrue(priceCalculatorPage.getInstanceTypeEstimate().contains("Instance type: n1-standard-8"));
    }

    @Test
    public void checkRegionEstimateTest () {
        Assert.assertTrue(priceCalculatorPage.getRegionEstimate().contains("Region: Frankfurt"));
    }

    @Test
    public void checkLocalSSDEstimateTest (){
        Assert.assertTrue(priceCalculatorPage.getLocalSSDEstimate().contains("Total available local SSD space 2x375 GB"));
    }

    @Test
    public void checkCommitmentTermEstimateTest (){
        Assert.assertTrue(priceCalculatorPage.getCommitmentTermEstimate().contains("Commitment term: 1 Year"));
    }

    @Test
    public void checkVMclassEstimateTest () {
        Assert.assertTrue(priceCalculatorPage.getVMClassEstimate().contains("VM class: regular"));
    }

    @Test
    public void checkTotalEstimatedCostTest () {
        Assert.assertTrue(priceCalculatorPage.getTotalEstimatedCost().contains("Total Estimated Cost: USD 1,187.77 per 1 month"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver=null;
    }

}
