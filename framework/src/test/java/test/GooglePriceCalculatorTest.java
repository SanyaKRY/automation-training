package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverSingleton;
import model.ComputeEngine;
import page.GoogleCloudMainPage;
import page.PopUpWindowPage;
import page.PriceCalculatorPage;
import page.SearchResultsPage;
import page.TenMinuteMailPage;
import service.ComputeEngineCreator;
import util.TabSelection;

public class GooglePriceCalculatorTest extends CommonConditions{

  GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(DriverSingleton.getDriver()); 
  SearchResultsPage searchResultsPage = new SearchResultsPage(DriverSingleton.getDriver());
  PriceCalculatorPage priceCalculatorPage = new PriceCalculatorPage(DriverSingleton.getDriver());
  TenMinuteMailPage tenMinuteMailPage = new TenMinuteMailPage(DriverSingleton.getDriver());
  PopUpWindowPage popUpWindowPage = new PopUpWindowPage(DriverSingleton.getDriver());
  
  @Test
  public void totalCostFromLetterEqualsToEstimate() {	
	ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngine();
	googleCloudMainPage
	    .openPage()
	    .goToSearchResultsPage();
	searchResultsPage.goToPriceCalculatorPage();
	String totalCostFromEstimate = priceCalculatorPage
		.switchToFrame()
		.fillOutComputeEngineForm(computeEngine)
		.getTotalCostFromEstimate();
	String temporaryMail = tenMinuteMailPage
		.openTemporaryMailWindow()
		.getTenMinuteMailText();
	TabSelection.goToPreviousTab(driver);
	popUpWindowPage.switchToFrame().fillInEmailField(temporaryMail);
	TabSelection.goToNextTab(driver);
	String totalCostFromLetter = tenMinuteMailPage.openNewMessageAndGetFinalCostFromLetter();		
	Assert.assertTrue(totalCostFromEstimate.contains(totalCostFromLetter)
	    , "The total cost from estimate doesn't match total cost from letter");			
  }
  
}