package hardcore.tests;

import hardcore.pages.CloudGooglePage;
import hardcore.pages.PriceCalculatorPage;
import hardcore.pages.TenMinuteMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriceCalculatorTest {
    private WebDriver driver;
    PriceCalculatorPage priceCalculatorPage;
    TenMinuteMailPage tenMinuteMailPage;

    @BeforeTest
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        priceCalculatorPage = new CloudGooglePage(driver).openPage().clickOnCalculatorLink().switchToFrame().fillOutForm();
    }

    @Test
    public void someTest () {
        String costFromEstimate = priceCalculatorPage.getTotalEstimatedCost();
        String mainWindow = driver.getWindowHandle();
        tenMinuteMailPage = new TenMinuteMailPage(driver).openTenMinuteMailPage();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        String secondWindow = driver.getWindowHandle();
        String temporaryMail = tenMinuteMailPage.getTenMinuteMailText();
        driver.switchTo().window(mainWindow);
        priceCalculatorPage.switchToFrame().sendMessageToTenMinutesMail(temporaryMail);
        driver.switchTo().window(secondWindow);
        Assert.assertTrue(costFromEstimate.contains(tenMinuteMailPage.getFinalCostFromMessage()));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
        driver=null;
    }
}
