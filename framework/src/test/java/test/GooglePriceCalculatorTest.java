package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ComputeEngine;
import page.GoogleCloudMainPage;
import page.PopUpWindowPage;
import page.PriceCalculatorPage;
import page.TenMinuteMailPage;
import service.ComputeEngineCreator;
import util.TabSelection;

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
	TenMinuteMailPage tenMinuteMailPage = new TenMinuteMailPage(driver).openTemporaryMailWindow();
	String temporaryMail = tenMinuteMailPage.getTenMinuteMailText();
	TabSelection.goToPreviousTab(driver);
	PopUpWindowPage popUpWindowPage = new PopUpWindowPage(driver);		
	popUpWindowPage
        .switchToFrame()
	    .fillInEmailField(temporaryMail);
	TabSelection.goToNextTab(driver);			
	String totalCostFromLetter = tenMinuteMailPage.openNewMessageAndGetFinalCostFromLetter();			
	Assert.assertTrue(totalCostFromEstimate.contains(totalCostFromLetter), "The total estimated cost isn't correct");				
  }
  
}