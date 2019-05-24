package bring_it_on.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bring_it_on.pages.PastebinPage;
import bring_it_on.pages.SuccessfullyPostedPastebinPage;

public class PastebinTest {
	SuccessfullyPostedPastebinPage successfullyPostedPastebinPage;
	private WebDriver driver;	

    String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
        "git push origin master --force";	

	@BeforeTest
	public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        fillOutForm();
    }	
	
	public void fillOutForm() {
		successfullyPostedPastebinPage = new PastebinPage(driver)
		.openPage()
		.inputCode(code)
		.selectSyntax("Bash")
		.selectExpiration("10 Minutes")
		.inputTitle("how to gain dominance among developers")
		.pushCreateNewPasteButton();
	}
	
	@Test
    public void syntaxHighlightingForBashTest(){
		
        Assert.assertTrue(successfullyPostedPastebinPage.validatePageBash());
    }

    @Test
    public void pageTitleTest(){ 
    	
        String title = successfullyPostedPastebinPage.validatePageTittle();
        Assert.assertTrue(title.contains("how to gain dominance among developers"));
    }

    @Test    
    public void codIsEqualsToEnteredTest(){ 
    	
        Assert.assertEquals(successfullyPostedPastebinPage.checkCode(),code.replaceAll("\\s+",""));
    }	
	
	@AfterTest
	public void TernDown(){
		driver.quit();  
		driver=null;
    } 
}
