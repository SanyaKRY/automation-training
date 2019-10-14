package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import model.ComputeEngineUser;
import util.WaitingSomeConditions;

public class PriceCalculatorPage extends AbstractPage {
	
  private final String PRICE_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator/";
  private final Logger logger = LogManager.getRootLogger();
	
  @FindBy(id = "idIframe")
  private WebElement frame;
		
  @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
  private WebElement computeEngineLabelAndButton;

  @FindBy(id = "input_53")
  private WebElement numberOfInstancesField;

  @FindBy(id="input_54")
  private WebElement instancesForField;

  @FindBy(id = "select_value_label_46")
  private WebElement dropDownBoxOperatingSystem;
  @FindBy(xpath = "//*[@id='select_container_66']//md-option")
  private List<WebElement> OperatingSystemList;    

  @FindBy(id = "select_value_label_47")
  private WebElement dropDownBoxVMClass;
  @FindBy(xpath = "//*[@id='select_container_70']//md-option")
  private List<WebElement> VMClassList;
	    
  @FindBy(id = "select_value_label_49")
  private WebElement dropDownBoxInstanceType;
  @FindBy(xpath = "//*[@id='select_container_77']//md-option")
  private List<WebElement> instanceTypeList;    
	 
  @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
  private WebElement addGPUs;  
  	  
  @FindBy(id = "select_value_label_346")
  private WebElement dropDownBoxNumberOfGPUs;
  @FindBy(xpath = "//*[@id='select_container_349']//md-option")
  private List<WebElement> numberOfGPUsList;
	    
  @FindBy(id = "select_value_label_347")
  private WebElement dropDownBoxGPUType;
  @FindBy(xpath = "//*[@id='select_container_351']//md-option/div")
  private List<WebElement> GPUTypeList;
	    		  
  @FindBy(xpath = "//*[@id='select_value_label_50']")
  private WebElement dropDownBoxLocalSSD;
  @FindBy(xpath = "//*[@id='select_container_79']//md-option/div")
  private List<WebElement> localSSDList;
	  
  @FindBy(id = "select_value_label_51")
  private WebElement dropDownBoxDatacenterLocation;
  @FindBy(xpath = "//*[@id='select_container_81']//md-option/div")
  private List<WebElement> datacenterLocationList;

  @FindBy(id = "select_value_label_52")
  private WebElement dropDownBoxCommitedUsage;
  @FindBy(xpath = "//*[@id='select_container_86']//md-option/div")
  private List<WebElement> commitedUsageList;

  @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and @aria-label='Add to Estimate']")
  private WebElement addToEstimateButton;

  private final By labelComputeEngine = By.xpath("//*[@id='compute']/md-toolbar//*[text()='Compute Engine']");   
	     		    
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;
  
  @FindBy(xpath = "//*[@class='md-title']/b[@class='ng-binding']")
  private WebElement CostFromEstimate;
	  
  private final By labelGoogleCloudPlatformPricingCalculator = By.xpath("/html/body/md-content/md-card/md-toolbar/div/div[1]/h2");
  private final By labelResultBlockEstimate = By.xpath("//*[@id='resultBlock']//*[text()='Estimate']");
	
  public PriceCalculatorPage(WebDriver driver) {
	super(driver);
  }

  @Override
  protected AbstractPage openPage() {
	driver.get(PRICE_CALCULATOR_PAGE_URL);
	return this;
  }
	
  public void selectParameter(List<WebElement> parameters, String parameter) {
	WaitingSomeConditions.waitForElementVisibilityOf(driver, parameters.get(0));
	for(WebElement webElement: parameters) {
	  if(webElement.getText().contains(parameter)) {
	    webElement.click();
	    break;
	  }
	}
  }
	  
  public boolean islabelResultBlockEstimateDisplayed() {
	return WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelResultBlockEstimate).isDisplayed();
  }
	
  public boolean islabelGoogleCloudPlatformPricingCalculatorDisplayed() {
	return WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelGoogleCloudPlatformPricingCalculator).isDisplayed();
  }
	    
  public PriceCalculatorPage switchToFrame(){
	new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    return this;
  }
	 
  public PriceCalculatorPage fillOutForm(ComputeEngineUser computeEngineUser) {
	computeEngineLabelAndButton.click();
	numberOfInstancesField.sendKeys(String.valueOf(computeEngineUser.getNumberOfInstances()));
	instancesForField.sendKeys(computeEngineUser.getInstancesFor());
	dropDownBoxOperatingSystem.click();
	selectParameter(OperatingSystemList, computeEngineUser.getOperatingSystem());
	WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxVMClass).click();
	selectParameter(VMClassList, computeEngineUser.getVMClass());
	WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxInstanceType).click();
	selectParameter(instanceTypeList, computeEngineUser.getInstanceType());
	if (computeEngineUser.isAddGPUs()) {
      WaitingSomeConditions.waitForElementVisibilityOf(driver, addGPUs).click();
      WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxNumberOfGPUs).click();
      selectParameter(numberOfGPUsList,computeEngineUser.getNumberOfGPUs());
      dropDownBoxGPUType.click();
      selectParameter(GPUTypeList,computeEngineUser.getGPUType());
	}   
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropDownBoxCommitedUsage);
	Actions actions = new Actions(driver);
	actions.moveToElement(dropDownBoxCommitedUsage).build().perform();
	WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxLocalSSD).click();
	selectParameter(localSSDList,computeEngineUser.getLocalSSD());  
	dropDownBoxDatacenterLocation.click();
	selectParameter(datacenterLocationList, computeEngineUser.getDatacenterLocation());
	dropDownBoxCommitedUsage.click();
	selectParameter(commitedUsageList, computeEngineUser.getCommitedUsage());
	logger.info("the form is filled");
	return this;
  }		  
	  
  public PriceCalculatorPage  pressEmailEstimateButton() {
	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelComputeEngine);
	emailEstimateButton.click();	
	logger.info("Email estimate button pressed");
	return this;
  }
	  
  public PriceCalculatorPage pressAddToEstimateButton() {
	WaitingSomeConditions.waitForElementVisibilityOf(driver, addToEstimateButton).click();
	logger.info("add to estimate button pressed");
	return this;
  }
	  
  public String getTotalCostFromEstimate() {
	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelComputeEngine);
	return CostFromEstimate.getText();
  }

}
