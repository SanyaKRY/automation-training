package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ComputeEngine;
import page.GoogleCloudMainPage;
import page.PopUpWindowPage;
import page.PriceCalculatorPage;
import page.SearchResultsPage;
import page.TenMinuteMailPage;
import service.ComputeEngineCreator;
import util.TabSelection;

public class GooglePriceCalculatorTest extends CommonConditions{

  GoogleCloudMainPage  googleCloudMainPage; 
  SearchResultsPage searchResultsPage;
  PriceCalculatorPage priceCalculatorPage;
  TenMinuteMailPage tenMinuteMailPage;
  PopUpWindowPage popUpWindowPage;
	
  @Test
  public void totalCostFromLetterEqualsToEstimate() {
	googleCloudMainPage= new GoogleCloudMainPage(driver) ; 
	searchResultsPage = new SearchResultsPage(driver);
	priceCalculatorPage = new PriceCalculatorPage(driver);
	tenMinuteMailPage = new TenMinuteMailPage(driver);
	popUpWindowPage = new PopUpWindowPage(driver);
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