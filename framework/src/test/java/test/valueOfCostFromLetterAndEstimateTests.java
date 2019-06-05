package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ComputeEngineUser;
import page.CloudGoogleMainPage;
import page.PriceCalculatorPage;
import page.TenMinuteMailPage;
import service.ComputeEngineUserCreator;

public class valueOfCostFromLetterAndEstimateTests extends CommonConditions {
	
	@Test
	public void compareValueOfpriceFromLetterAndEstimate() {
		
		ComputeEngineUser testUser = ComputeEngineUserCreator.UserFromTaskHardcore();		
		PriceCalculatorPage priceCalculatorPage = new CloudGoogleMainPage(driver)
		.openPage()
		.goToPriceCalculatorPage()
		.switchToFrame()
		.fillOutForm(testUser);			
		String costFromEstimate = priceCalculatorPage.getTotalCostFromEstimate();
		System.out.println(costFromEstimate);		
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
		System.out.println(finalCostFromLetter);
		Assert.assertTrue(costFromEstimate.contains(finalCostFromLetter));
		
	}

}
