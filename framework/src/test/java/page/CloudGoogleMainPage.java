package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.WaitingSomeConditions;

public class CloudGoogleMainPage extends AbstractPage {
	
	private final String CLOUD_GOOGLE_MAIN_PAGE_URL = "https://cloud.google.com/";
	private final Logger logger = LogManager.getRootLogger();

	public CloudGoogleMainPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public CloudGoogleMainPage openPage() {
		driver.navigate().to(CLOUD_GOOGLE_MAIN_PAGE_URL);
		logger.info("CloudGoogleMainPage page opened");
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
    	WaitingSomeConditions.waitForElementVisibilityOf(driver, calculatorLink).click();
    	return new PriceCalculatorPage(driver);
    }

}
