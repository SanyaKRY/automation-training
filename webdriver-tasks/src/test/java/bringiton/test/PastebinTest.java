package bringiton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bringiton.pages.PageAfterCreationOfPastebin;
import bringiton.pages.PastebinPage;

public class PastebinTest {
	
protected WebDriver driver;
	
  protected static final String PASTE = "git config --global user.name  \"New Sheriff in Town\"\n" +
      "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
	  "git push origin master --force";
  protected static final String SYNTAX = "Bash";
  protected static final String EXPIRATION = "10 Minutes";
  protected static final String TITLE = "how to gain dominance among developers";	
	
  PageAfterCreationOfPastebin pageAfterCreationOfPastebin;
	
  @BeforeClass
  public void SetUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize(); 
    pageAfterCreationOfPastebin = new PastebinPage(driver)
	    .openPage()
		.fillOutForm(PASTE, SYNTAX, EXPIRATION, TITLE);	
  }
	
  @Test
  public void pageTitleTest() { 		 	 
	String title = pageAfterCreationOfPastebin.validatePageTittle();
	Assert.assertTrue(title.contains("how to gain dominance among developers"));
  }
	 
  @Test
  public void syntaxHighlightingForBashTest() {
	Assert.assertTrue(pageAfterCreationOfPastebin.validatePageBash());
  }
	 
  @Test    
  public void codIsEqualsToEnteredTest() { 
	Assert.assertEquals(pageAfterCreationOfPastebin.checkCode(), PASTE.replaceAll("\\s+",""));
  }	
	
  @AfterClass
  public void TernDown() {
	driver.quit();  
	driver = null;
  }

}
