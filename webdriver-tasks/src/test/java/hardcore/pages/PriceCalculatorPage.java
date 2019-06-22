package hardcore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceCalculatorPage extends AbstractPage {
	
	public PriceCalculatorPage(WebDriver driver) {
		super(driver);
	}
	
	private final String PRICE_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator/";
	
	@Override
	public PriceCalculatorPage openPage() {
		driver.get(PRICE_CALCULATOR_PAGE_URL);
		return this;		
	}
	
	@FindBy(id="idIframe")
    private WebElement frame;
	
	@FindBy(xpath="//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngine;

    @FindBy(id="input_52")
    private WebElement numberOfInstances;

    @FindBy(id="input_53")
    private WebElement instancesFor;

    @FindBy(id="select_value_label_45")
    private WebElement dropDownBoxOperatingSystem;
    @FindBy(xpath="//*[@id='select_container_65']//md-option")
    private List<WebElement> OperatingSystemList;    

    @FindBy(id="select_value_label_46")
    private WebElement dropDownBoxVMClass;
    @FindBy(xpath="//*[@id='select_container_69']//*[@class='md-text']")
    private List<WebElement> VMClassList;
    
    @FindBy(id="select_value_label_48")
    private WebElement dropDownBoxInstanceType;
    @FindBy(xpath="//*[@id='select_container_76']//md-option")
    private List<WebElement> instanceTypeList;    
  
    @FindBy(xpath="//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUs;    

    @FindBy(id="select_value_label_334")
    private WebElement dropDownBoxNumberOfGPUs;
    @FindBy(xpath="//*[@id='select_container_337']//md-option")
    private List<WebElement> numberOfGPUsList;
    
    @FindBy(id="select_value_label_335")
    private WebElement dropDownBoxGPUType;
    @FindBy(xpath="//*[@id='select_container_339']//md-option")
    private List<WebElement> GPUTypeList;
    
    @FindBy(id="select_value_label_49")
    private WebElement dropDownBoxLocalSSD;
    @FindBy(xpath="//*[@id='select_container_78']//md-option/div")
    private List<WebElement> localSSDList;
  
    @FindBy(id="select_value_label_50")
    private WebElement dropDownBoxDatacenterLocation;
    @FindBy(xpath="//*[@id='select_container_80']//md-option/div")
    private List<WebElement> datacenterLocationList;

    @FindBy(id="select_value_label_51")
    private WebElement dropDownBoxCommitedUsage;
    @FindBy(xpath="//*[@id='select_container_85']//md-option/div")
    private List<WebElement> commitedUsageList;

    @FindBy(xpath="//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and @aria-label='Add to Estimate']")
    private WebElement addToEstimate;

    private final By labelComputeEngine = By.xpath("//*[@id='compute']/md-toolbar//*[text()='Compute Engine']");   
        
    @FindBy(xpath="//*[@class='md-title']/b[@class='ng-binding']")
    private WebElement CostFromEstimate;
    
    @FindBy(id="email_quote")
    private WebElement emailEstimateButton;
    
    private final By labelEmailYourEstimate = By.xpath("//*[@id='dialogContent_395']//*[text()='Email Your Estimate']");
    
    @FindBy(id="input_389")
    private WebElement fieldForEmail;

    @FindBy(xpath="//*[@id='dialogContent_395']//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;    
        
    public void selectParameter(List<WebElement> parameters, String parameter) {
    	waitForElementVisibilityOf(driver, parameters.get(0));
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
    
    public PriceCalculatorPage fillOutForm(String NumberOfInstances, String InstancesFor, String OperatingSystem, String VMClass, String InstanceType, 
    		String NumberOfGPUs, String GPUType, String LocalSSD, String DatacenterLocation, String CommitedUsage) {
    	computeEngine.click();
    	numberOfInstances.sendKeys(NumberOfInstances);
    	instancesFor.sendKeys(InstancesFor);
    	dropDownBoxOperatingSystem.click();
    	selectParameter(OperatingSystemList, OperatingSystem);
    	waitForElementVisibilityOf(driver, dropDownBoxVMClass).click();
    	selectParameter(VMClassList, VMClass);
    	waitForElementVisibilityOf(driver, dropDownBoxInstanceType).click();
    	selectParameter(instanceTypeList, InstanceType);
    	waitForElementVisibilityOf(driver, addGPUs).click();
    	waitForElementVisibilityOf(driver, dropDownBoxNumberOfGPUs).click();
        selectParameter(numberOfGPUsList, NumberOfGPUs);
        dropDownBoxGPUType.click();
        selectParameter(GPUTypeList, GPUType);
    	Actions actions = new Actions(driver);
    	actions.moveToElement(dropDownBoxLocalSSD).build().perform();
    	dropDownBoxLocalSSD.click();
    	selectParameter(localSSDList,LocalSSD);    	
    	actions.moveToElement(dropDownBoxDatacenterLocation).build().perform();
    	dropDownBoxDatacenterLocation.click();
    	selectParameter(datacenterLocationList, DatacenterLocation);
    	dropDownBoxCommitedUsage.click();
    	selectParameter(commitedUsageList, CommitedUsage); 
    	waitForElementVisibilityOf(driver, addToEstimate).click();
    	return this;
    }
    
    public String getTotalCostFromEstimate() {
    	waitForPresenceOfElementLocated(driver, labelComputeEngine);
    	return CostFromEstimate.getText();
    }
        
    public void sendMessageToTenMinutesMail(String email) {
    	waitForPresenceOfElementLocated(driver, labelComputeEngine);
    	emailEstimateButton.click();
    	waitForPresenceOfElementLocated(driver, labelEmailYourEstimate);
    	fieldForEmail.click();
    	fieldForEmail.clear(); 	
    	fieldForEmail.sendKeys(email);    	
    	sendEmailButton.click();
    }

}
