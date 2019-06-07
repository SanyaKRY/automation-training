package hurt_me_plenty;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingSomeConditions {
	
	static final int WAIT_TIMEOUT_SECONDS=15;
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement waitForPresenceOfElementLocated(WebDriver driver, By by) {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void waitForJquery(WebDriver driver){
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }

}
