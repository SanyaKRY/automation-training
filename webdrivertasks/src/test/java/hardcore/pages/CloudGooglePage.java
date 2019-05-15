package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGooglePage extends AbstractPage {

    private static final String PAGE_URL="https://cloud.google.com/";

    @FindBy(xpath="//*[@track-name='products' and @track-type='globalNav']")
    private WebElement products;

    @FindBy(xpath="//*[@track-name='pricing' and @track-type='globalNav']")
    private WebElement pricing;

    @FindBy(xpath="//*[@href='https://cloud.google.com/products/calculator/' and @track-name='pricing']")
    private WebElement calculatorLink;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
    }

    public CloudGooglePage openPage(){
        driver.get(PAGE_URL);
        return this;
    }

    public PriceCalculatorPage clickOnCalculatorLink(){
        products.click();
        pricing.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(calculatorLink)).click();
        return new PriceCalculatorPage(driver);
    }
}
