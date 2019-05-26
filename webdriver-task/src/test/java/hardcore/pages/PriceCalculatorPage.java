package hardcore.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hardcore.WaitingSomeConditions;

public class PriceCalculatorPage extends AbstractPage {
	
	public PriceCalculatorPage(WebDriver driver) {
		super(driver);
	}
	
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
    @FindBy(xpath="//*[@id=\"select_container_68\"]//*[@class='md-text']")
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

    @FindBy(id="email_quote")
    private WebElement emailEstimate;

    @FindBy(id="input_388")
    private WebElement emailMyEstimate;

    @FindBy(xpath="//*[@id='dialogContent_394']//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;    
    
    @FindBy(xpath="//*[@class='md-title']/b[@class='ng-binding']")
    private WebElement totalEstimatedCost;    
    
    public PriceCalculatorPage switchToFrame(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='idIframe']")));
        return this;
    }
    
    public PriceCalculatorPage pushComputeEngine() {    	
    	WaitingSomeConditions.waitForElementToBeClickable(driver, computeEngine).click();
        return this;
    }
    
    public PriceCalculatorPage pushNumberOfInstances(String number) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, numberOfInstances).sendKeys(number);
        return this;
    }
    
    public PriceCalculatorPage pushInstancesFor() {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, instancesFor).click();
        return this;
    }    
    
    public PriceCalculatorPage selectOperatingSystem(String OperatingSystem) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxOperatingSystem).click();
        selectParameter(OperatingSystemList, OperatingSystem);
        return this;
    }
    
    public PriceCalculatorPage selectVMClass(String VMClass) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxVMClass).click();
        selectParameter(VMClassList, VMClass);
        return this;
    }
    
    public PriceCalculatorPage selectInstanceType(String instanceType) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxInstanceType).click();
        selectParameter(instanceTypeList, instanceType);
        return this;
    }
    
    public PriceCalculatorPage pushAddGPUs() {    	
    	WaitingSomeConditions.waitForElementToBeClickable(driver, addGPUs).click();
        return this;
    }
    
    public PriceCalculatorPage selectNumberOfGPUs(String NumberOfGPUs) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxNumberOfGPUs).click();
        selectParameter(numberOfGPUsList, NumberOfGPUs);
        return this;
    }
    
    public PriceCalculatorPage selectGPUType(String GPUType) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxGPUType).click();
        selectParameter(GPUTypeList, GPUType);
        return this;
    }
    
    public PriceCalculatorPage selectLocalSSD(String LocalSSD) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxLocalSSD).click();
        selectParameter(localSSDList, LocalSSD);
        return this;
    }
    
    public PriceCalculatorPage selectDatacenterLocation(String DatacenterLocation) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxDatacenterLocation).click();
        selectParameter(datacenterLocationList, DatacenterLocation);
        return this;
    }
    
    public PriceCalculatorPage selectCommitedUsage(String CommitedUsage) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, dropDownBoxCommitedUsage).click();
        selectParameter(commitedUsageList, CommitedUsage);
        return this;
    }
    
    public PriceCalculatorPage pushAddToEstimate() {    	
    	WaitingSomeConditions.waitForElementToBeClickable(driver, addToEstimate).click();
        return this;
    }
    
    
    public void selectParameter(List<WebElement> parameters, String parameter) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver, parameters.get(0));
        for(WebElement webElement: parameters) {
            if(webElement.getText().contains(parameter)) {            	
            	 webElement.click();
                break;
            }
        }
    }
    
    public PriceCalculatorPage sendMessageToTenMinutesMail(String email) {
    	WaitingSomeConditions.waitForElementToBeClickable(driver,emailEstimate).click();
	emailMyEstimate.click();
    	WaitingSomeConditions.waitForElementToBeClickable(driver,emailMyEstimate).sendKeys(email); 
    	sendEmailButton.click();
    	return this;
    }

    public String getFinalCostFromEstimate() {
    	return totalEstimatedCost.getText();
    }
}
