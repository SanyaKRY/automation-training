package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ComputeEngine;
import page.GoogleCloudMainPage;
import page.PopUpWindowPage;
import page.PriceCalculatorPage;
import page.TenMinuteMailPage;
import service.ComputeEngineCreator;

public class GooglePriceCalculatorTest extends CommonConditions{
  @Test
  public void totalCostFromLetterEqualsToEstimate() {
	ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngine();	
	PriceCalculatorPage  priceCalculatorPage = new GoogleCloudMainPage(driver)
	    .openPage()
		.goToSearchResultsPage()
		.goToPriceCalculatorPage()
		.switchToFrame()
		.fillOutComputeEngineForm(computeEngine);
	String totalCostFromEstimate = priceCalculatorPage.getTotalCostFromEstimate();
	String mainWindow = driver.getWindowHandle();	
		
	TenMinuteMailPage tenMinuteMailPage=new TenMinuteMailPage(driver).openTemporaryMailWindow();
		
	for (String window : driver.getWindowHandles()) {
	  driver.switchTo().window(window);
	}	
	
	String temporaryMail = tenMinuteMailPage.getTenMinuteMailText();
	String secondWindow = driver.getWindowHandle();
	driver.switchTo().window(mainWindow);
	PopUpWindowPage popUpWindowPage= new PopUpWindowPage(driver);		
	popUpWindowPage
	  .switchToFrame()
	  .fillInEmailField(temporaryMail);
	driver.switchTo().window(secondWindow);
		
	String totalCostFromLetter = tenMinuteMailPage.openNewMessageAndGetFinalCostFromLetter();
		
	Assert.assertTrue(totalCostFromEstimate.contains(totalCostFromLetter), "The total estimated cost isn't correct");
			
	}
}
