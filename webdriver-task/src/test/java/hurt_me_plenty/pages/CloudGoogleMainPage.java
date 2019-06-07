package hurt_me_plenty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hurt_me_plenty.WaitingSomeConditions;

public class CloudGoogleMainPage extends AbstractPage {

	private final String CLOUD_GOOGLE_MAIN_PAGE_URL = "https://cloud.google.com/";

	public CloudGoogleMainPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public CloudGoogleMainPage openPage() {
		driver.get(CLOUD_GOOGLE_MAIN_PAGE_URL);
        WaitingSomeConditions.waitForJquery(driver);
        return this;		
	}
	
	@FindBy(xpath="//*[@track-name='products' and @track-type='globalNav']")
    private WebElement products;

    @FindBy(xpath="//*[@track-name='pricing' and @track-type='globalNav']")
    private WebElement pricing;

    @FindBy(xpath="//*[@href='https://cloud.google.com/products/calculator/' and @track-name='pricing']")
    private WebElement calculatorLink;
    
    public PriceCalculatorPage goToPriceCalculatorPage(){ 
    	products.click();
    	pricing.click();
    	WaitingSomeConditions.waitForVisibilityOfElement(driver, calculatorLink).click();
    	return new PriceCalculatorPage(driver);
    }
    
}
