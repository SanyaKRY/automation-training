package page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import model.ComputeEngine;
import util.WaitingSomeConditions;

public class PriceCalculatorPage extends AbstractPage {
	
  private final Logger logger = LogManager.getRootLogger();
  private final String PRICE_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator/";
  
  public PriceCalculatorPage(WebDriver driver) {
	super(driver);
  }

  @Override
  public PriceCalculatorPage openPage() {
	driver.navigate().to(PRICE_CALCULATOR_PAGE_URL);
	return this;		
  }
		
  @FindBy(id="myFrame")
  private WebElement frame;
	
  @FindBy(xpath="//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
  private WebElement computeEngineLabelAndButton;
	
  @FindBy(id="input_53")
  private WebElement numberOfInstancesField;

  @FindBy(id="input_54")
  private WebElement instancesForField;
	  
  @FindBy(id="select_value_label_46")
  private WebElement dropDownBoxOperatingSystem;
  @FindBy(xpath="//*[@id='select_container_66']//md-option")
  private List<WebElement> OperatingSystemList; 
	  
  @FindBy(id="select_value_label_47")
  private WebElement dropDownBoxVMClass;
  @FindBy(xpath="//*[@id='select_container_70']//md-option")
  private List<WebElement> VMClassList;
	  
  @FindBy(id="select_value_label_49")
  private WebElement dropDownBoxInstanceType;
  @FindBy(xpath="//*[@id='select_container_77']//md-option")
  private List<WebElement> instanceTypeList;    
	 
  @FindBy(xpath="//*[@ng-model='listingCtrl.computeServer.addGPUs']")
  private WebElement addGPUs;  
	  
  @FindBy(id="select_value_label_346")
  private WebElement dropDownBoxNumberOfGPUs;
  @FindBy(xpath="//*[@id='select_container_349']//md-option")
  private List<WebElement> numberOfGPUsList;
	    
  @FindBy(id="select_value_label_347")
  private WebElement dropDownBoxGPUType;
  @FindBy(xpath="//*[@id='select_container_351']//md-option/div")
  private List<WebElement> GPUTypeList;
	  
  @FindBy(xpath="//*[@id='select_value_label_50']")
  private WebElement dropDownBoxLocalSSD;
  @FindBy(xpath="//*[@id='select_container_79']//md-option/div")
  private List<WebElement> localSSDList;
	  
  @FindBy(id="select_value_label_51")
  private WebElement dropDownBoxDatacenterLocation;
  @FindBy(xpath="//*[@id='select_container_81']//md-option/div")
  private List<WebElement> datacenterLocationList;
	  
  @FindBy(id="select_value_label_52")
  private WebElement dropDownBoxCommitedUsage;
  @FindBy(xpath="//*[@id='select_container_86']//md-option/div")
  private List<WebElement> commitedUsageList;
	  
  @FindBy(xpath="//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and @aria-label='Add to Estimate']")
  private WebElement addToEstimateButton;
	  
  @FindBy(xpath = "//*[@class='md-title']/b[@class='ng-binding']")
  private WebElement CostFromEstimate;
	  
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;
	  
  
  public void selectParameter(List<WebElement> parameters, String parameter) {
	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(parameters.get(0)));
	for(WebElement webElement: parameters) {
	  if(webElement.getText().contains(parameter)) {
		webElement.click();
		break;
	  }
	}
  }
	
  public PriceCalculatorPage switchToFrame(){
	new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	return this;
  }
	  
  public PriceCalculatorPage fillOutComputeEngineForm(ComputeEngine computeEngine) {
	computeEngineLabelAndButton.click();
	numberOfInstancesField.sendKeys(computeEngine.getNumberOfInstances());
	instancesForField.sendKeys(computeEngine.getInstancesFor());
	dropDownBoxOperatingSystem.click();
	selectParameter(OperatingSystemList,computeEngine.getOperatingSystem());
	dropDownBoxVMClass.click();
	selectParameter(VMClassList,computeEngine.getVmClass());	
	WaitingSomeConditions.moveinViewPort(dropDownBoxInstanceType);	
	dropDownBoxInstanceType.click();
	selectParameter(instanceTypeList,computeEngine.getInstanceType());
	if (computeEngine.isAddGPUs()) {
	  addGPUs.click();
	  dropDownBoxNumberOfGPUs.click();
	  selectParameter(numberOfGPUsList,computeEngine.getNumberOfGPUs());	    		
	  dropDownBoxGPUType.click();
	  selectParameter(GPUTypeList,computeEngine.getGpuType());
	}
	WaitingSomeConditions.moveinViewPort(dropDownBoxLocalSSD);
	dropDownBoxLocalSSD.click();		
	selectParameter(localSSDList,computeEngine.getLocalSSD());	
	WaitingSomeConditions.moveinViewPort(dropDownBoxDatacenterLocation);			
	dropDownBoxDatacenterLocation.click();		
	selectParameter(datacenterLocationList, computeEngine.getDatacenterLocation());		
	dropDownBoxCommitedUsage.click();
	selectParameter(commitedUsageList, computeEngine.getCommitedUsage());
	addToEstimateButton.click();
	logger.info("the form is filled");
	return this;	
  }
	  
  public String getTotalCostFromEstimate() {
	emailEstimateButton.click();
	logger.info("total cost from estimate is received");
	return CostFromEstimate.getText();
  }
	
}
