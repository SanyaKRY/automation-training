package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hardcore.WaitingSomeConditions;

public class CloudGooglePage extends AbstractPage {

	public CloudGooglePage(WebDriver driver) {
		super(driver);
	}
	
	private static final String PAGE_URL="https://cloud.google.com/";
	
	@FindBy(xpath="//*[@track-name='products' and @track-type='globalNav']")
    private WebElement products;

    @FindBy(xpath="//*[@track-name='pricing' and @track-type='globalNav']")
    private WebElement pricing;

    @FindBy(xpath="//*[@href='https://cloud.google.com/products/calculator/' and @track-name='pricing']")
    private WebElement calculatorLink;
	
    public CloudGooglePage openPage(){
        driver.get(PAGE_URL);
        WaitingSomeConditions.waitForJquery(driver);
        return this;
    }
    
    public PriceCalculatorPage goToPriceCalculatorPage(){ 
    	WaitingSomeConditions.waitForElementToBeClickable(driver, products).click();
    	pricing.click();
    	WaitingSomeConditions.waitForElementToBeClickable(driver, calculatorLink).click();
    	return new PriceCalculatorPage(driver);
    }

}
