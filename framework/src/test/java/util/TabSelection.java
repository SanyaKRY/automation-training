package util;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class TabSelection {
	
  private static ArrayList<String> tabs;
	
  public static void goToNextTab(WebDriver driver) {
	int indexOfNextTab = indexOfCurrentTab(driver)+1;
	driver.switchTo().window(tabs.get(indexOfNextTab));
  }

  public static void goToPreviousTab(WebDriver driver) {
	int indexOfPreviousTab = indexOfCurrentTab(driver)-1;
	driver.switchTo().window(tabs.get(indexOfPreviousTab));		
  }

  private static int indexOfCurrentTab(WebDriver driver) {
	tabs = new ArrayList<String> (driver.getWindowHandles());
	return tabs.indexOf( driver.getWindowHandle());	 
  }
}
