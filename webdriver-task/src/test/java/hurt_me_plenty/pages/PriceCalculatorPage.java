package hurt_me_plenty.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hurt_me_plenty.WaitingSomeConditions;

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

    private final By labelComputeEngine = By.xpath("//*[@id='compute']/md-toolbar//*[text()='Compute Engine']");   
        
    @FindBy(xpath="//*[@class='md-title']/b[@class='ng-binding']")
    private WebElement CostFromEstimate;
    
    @FindBy(xpath="//*[@id='compute']/md-list//*[@role='listitem']/div")
    private List<WebElement> estimateContent;
  
     
        
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
    
    public PriceCalculatorPage fillOutForm(String NumberOfInstances, String InstancesFor, String OperatingSystem, String VMClass, String InstanceType, 
    		String NumberOfGPUs, String GPUType, String LocalSSD, String DatacenterLocation, String CommitedUsage) {
    	computeEngine.click();
    	numberOfInstances.sendKeys(NumberOfInstances);
    	instancesFor.sendKeys(InstancesFor);
    	dropDownBoxOperatingSystem.click();
    	selectParameter(OperatingSystemList, OperatingSystem); 
    	WaitingSomeConditions.waitForVisibilityOfElement(driver, dropDownBoxVMClass).click();
    	selectParameter(VMClassList, VMClass); 
    	WaitingSomeConditions.waitForVisibilityOfElement(driver, dropDownBoxInstanceType).click();
    	selectParameter(instanceTypeList, InstanceType);  
    	WaitingSomeConditions.waitForVisibilityOfElement(driver, addGPUs).click();
    	WaitingSomeConditions.waitForVisibilityOfElement(driver, dropDownBoxNumberOfGPUs).click();
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
    	WaitingSomeConditions.waitForVisibilityOfElement(driver, addToEstimate).click();
    	return this;
    }
    
    public boolean comparesValuesFromEstimate(String VMClass, String instanceType, String region, String localSSD, String commitmentTerm) {  
    	WaitingSomeConditions.waitForPresenceOfElementLocated(driver, labelComputeEngine);
    	System.out.println(estimateContent.get(1).getText()+" "+estimateContent.get(2).getText()+" "+estimateContent.get(3).getText()+" "+
    			estimateContent.get(4).getText()+" "+estimateContent.get(5).getText());
    	if (estimateContent.get(1).getText().contains(VMClass.toLowerCase())
    			&&estimateContent.get(2).getText().contains(instanceType)
    		    &&estimateContent.get(3).getText().contains(region)
    		    &&estimateContent.get(4).getText().contains(localSSD)
    		    &&estimateContent.get(5).getText().contains(commitmentTerm)) 
    		return true;	
			return false;
    }
    
    public boolean comparesTotalCostFromEstimate(String totalEstimateCost) {
    	if(CostFromEstimate.getText().contains(totalEstimateCost))
    		return true;	
		    return false;
    }    	
  
}
    
