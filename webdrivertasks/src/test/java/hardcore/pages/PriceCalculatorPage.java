package hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceCalculatorPage extends AbstractPage {

    public PriceCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngine;

    @FindBy(id="input_49")
    private WebElement numberOfInstances;

    @FindBy(id="input_50")
    private WebElement instancesFor;

    @FindBy(id="select_value_label_43")
    private WebElement operatingSystem;
    @FindBy(xpath="//md-option/div[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")
    private WebElement selectOperatingSystem;

    @FindBy(id="select_value_label_44")
    private WebElement VMClass;
    @FindBy(xpath="//*[@class='md-select-menu-container md-active md-clickable']//div[text()='Regular']")
    private WebElement selectVMClass;

    @FindBy(id="select_value_label_45")
    private WebElement instanceType;
    @FindBy(xpath="//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement selectInstanceType;

    @FindBy(xpath="//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUs;

    @FindBy(id="select_value_label_330")
    private WebElement numberOfGPUs;
    @FindBy(xpath="//div[text()='1']")
    private WebElement selectNumberOfGPUs;

    @FindBy(id="select_value_label_331")
    private WebElement GPUType;
    @FindBy(xpath="//div[text()='NVIDIA Tesla V100']")
    private WebElement selectGPUType;

    @FindBy(id="select_value_label_46")
    private WebElement localSSD;
    @FindBy(xpath="//div[text()='2x375 GB']")
    private WebElement selectlocalSSD;

    @FindBy(id="select_value_label_47")
    private WebElement datacenterLocation;
    @FindBy(xpath="//div[@id='select_container_101']//div[text()='Frankfurt (europe-west3)']")
    private WebElement selectDatacenterLocation;

    @FindBy(id="select_value_label_48")
    private WebElement commitedUsage;
    @FindBy(xpath="//div[@id='select_container_106']//div[text()='1 Year']")
    private WebElement selectCommitedUsage;

    @FindBy(xpath="//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and @aria-label='Add to Estimate']")
    private WebElement addToEstimate;

    @FindBy(id="compute")
    private WebElement computeItems;

    @FindBy(id="email_quote")
    private WebElement emailEstimate;

    @FindBy(id="input_385")
    private WebElement emailMyEstimate;

    @FindBy(xpath="//*[@id='dialogContent_391']//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath="//*[@class='md-title']/b[@class='ng-binding']")
    private WebElement totalEstimatedCost;

    public PriceCalculatorPage switchToFrame(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='idIframe']")));
        return this;
    }

    public PriceCalculatorPage fillOutForm(){
        computeEngine.click();
        numberOfInstances.sendKeys("4");
        instancesFor.click();
        operatingSystem.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectOperatingSystem)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(VMClass)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectVMClass)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(instanceType)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectInstanceType)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(addGPUs)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(numberOfGPUs)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectNumberOfGPUs)).click();
        GPUType.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectGPUType)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(commitedUsage)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectCommitedUsage)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(localSSD)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectlocalSSD)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(datacenterLocation)).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selectDatacenterLocation)).click();
        addToEstimate.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(emailEstimate)).click();
        return this;
    }

    public String getTotalEstimatedCost(){
        return totalEstimatedCost.getText();
    }

     public PriceCalculatorPage sendMessageToTenMinutesMail(String email){
         new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(emailMyEstimate)).sendKeys(email);
         new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        return this;
     }
}
