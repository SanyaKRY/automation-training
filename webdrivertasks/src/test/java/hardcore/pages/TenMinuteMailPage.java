package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPage extends AbstractPage {

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="copy-button")
    private WebElement tenMinuteMailTextCopyButton;

    @FindBy(xpath="//*[@id='maillist']//a[text()='Google Cloud Platform Price Estimate']")
    private WebElement newMessageFromGoogleCloudPlatformPriceEstimate;

    @FindBy(xpath="//*[@class='quote']//h3[text()='USD 1,187.77']")
    private WebElement finalCostFromMessage;


    public TenMinuteMailPage openTenMinuteMailPage(){
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", "https://10minutemail.net/");
        return this;
    }

    public String getTenMinuteMailText(){
        return new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(tenMinuteMailTextCopyButton)).getAttribute("data-clipboard-text");
    }

    public String getFinalCostFromMessage(){
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(newMessageFromGoogleCloudPlatformPriceEstimate)).click();
        return finalCostFromMessage.getText();
    }
}
