package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.ComputeEngineUser;
import util.WaitingSomeConditions;

public class PriceCalculatorPage extends AbstractPage {

	public PriceCalculatorPage(WebDriver driver) {
		super(driver);
	}
	
	private final String PRICE_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator/";
	private final Logger logger = LogManager.getRootLogger();
	
	@Override
	public PriceCalculatorPage openPage() {
		driver.navigate().to(PRICE_CALCULATOR_PAGE_URL);
		return this;		
	}
	
	@FindBy(id="idIframe")
    private WebElement frame;
	
	@FindBy(xpath="//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngine;

    @FindBy(id="input_51")
    private WebElement numberOfInstances;

    @FindBy(id="input_52")
    private WebElement instancesFor;

    @FindBy(id="select_value_label_44")
    private WebElement dropDownBoxOperatingSystem;
    @FindBy(xpath="//*[@id='select_container_64']//md-option")
    private List<WebElement> OperatingSystemList;    

    @FindBy(id="select_value_label_45")
    private WebElement dropDownBoxVMClass;
    @FindBy(xpath="//*[@id='select_container_68']//*[@class='md-text']")
    private List<WebElement> VMClassList;
    
    @FindBy(id="select_value_label_47")
    private WebElement dropDownBoxInstanceType;
    @FindBy(xpath="//*[@id='select_container_75']//md-option")
    private List<WebElement> instanceTypeList;    
  
    @FindBy(xpath="//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUs;    

    @FindBy(id="select_value_label_333")
    private WebElement dropDownBoxNumberOfGPUs;
    @FindBy(xpath="//*[@id='select_container_336']//md-option")
    private List<WebElement> numberOfGPUsList;
    
    @FindBy(id="select_value_label_334")
    private WebElement dropDownBoxGPUType;
    @FindBy(xpath="//*[@id='select_container_338']//md-option")
    private List<WebElement> GPUTypeList;
    
    @FindBy(id="select_value_label_48")
    private WebElement dropDownBoxLocalSSD;
    @FindBy(xpath="//*[@id='select_container_77']//md-option/div")
    private List<WebElement> localSSDList;
  
    @FindBy(id="select_value_label_49")
    private WebElement dropDownBoxDatacenterLocation;
    @FindBy(xpath="//*[@id='select_container_79']//md-option/div")
    private List<WebElement> datacenterLocationList;

    @FindBy(id="select_value_label_50")
    private WebElement dropDownBoxCommitedUsage;
    @FindBy(xpath="//*[@id='select_container_84']//md-option/div")
    private List<WebElement> commitedUsageList;

    @FindBy(xpath="//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and @aria-label='Add to Estimate']")
    private WebElement addToEstimate;

    private final By labelComputeEngine =By.xpath("//*[@id='compute']/md-toolbar//*[text()='Compute Engine']");   
        
    @FindBy(xpath="//*[@class='md-title']/b[@class='ng-binding']")
    private WebElement CostFromEstimate;
    
    @FindBy(id="email_quote")
    private WebElement emailEstimateButton;
    
    private final By labelEmailYourEstimate =By.xpath("//*[@id='dialogContent_394']//*[text()='Email Your Estimate']");
    
    @FindBy(id="input_388")
    private WebElement fieldForEmail;

    @FindBy(xpath="//*[@id='dialogContent_394']//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;    
        
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
    
    public PriceCalculatorPage fillOutForm(ComputeEngineUser computeEngineUser) {
	Actions actions = new Actions(driver);
    	computeEngine.click();
    	numberOfInstances.sendKeys(computeEngineUser.getNumberOfInstances());
    	instancesFor.sendKeys(computeEngineUser.getInstancesFor());
    	dropDownBoxOperatingSystem.click();
    	selectParameter(OperatingSystemList,computeEngineUser.getOperatingSystem()); 
    	WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxVMClass).click();
    	selectParameter(VMClassList,computeEngineUser.getVMClass());
    	WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxInstanceType).click();
    	selectParameter(instanceTypeList,computeEngineUser.getInstanceType());      	
    	if (computeEngineUser.isAddGPUs()) {
    		WaitingSomeConditions.waitForElementVisibilityOf(driver, addGPUs).click();
    		WaitingSomeConditions.waitForElementVisibilityOf(driver, dropDownBoxNumberOfGPUs).click();
        	selectParameter(numberOfGPUsList,computeEngineUser.getNumberOfGPUs());
        	dropDownBoxGPUType.click();
        	selectParameter(GPUTypeList,computeEngineUser.getGPUType());
	}  	
    	actions.moveToElement(dropDownBoxLocalSSD).build().perform();
    	dropDownBoxLocalSSD.click();
    	selectParameter(localSSDList,computeEngineUser.getLocalSSD());    	
    	actions.moveToElement(dropDownBoxDatacenterLocation).build().perform();
    	dropDownBoxDatacenterLocation.click();
    	selectParameter(datacenterLocationList,computeEngineUser.getDatacenterLocation());
    	dropDownBoxCommitedUsage.click();
    	selectParameter(commitedUsageList,computeEngineUser.getCommitedUsage()); 
    	WaitingSomeConditions.waitForElementVisibilityOf(driver, addToEstimate).click();
    	logger.info("form filled");
    	return this;
    }
    
    public String getTotalCostFromEstimate() {
    	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelComputeEngine);
    	return CostFromEstimate.getText();
    }
        
    public void sendMessageToTenMinutesMail(String email) {
    	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelComputeEngine);
    	emailEstimateButton.click();
    	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelEmailYourEstimate);   
    	fieldForEmail.clear(); 	
    	fieldForEmail.sendKeys(email);    	
    	sendEmailButton.click();
    	logger.info("email sent to temporary mail");
    }

}





























