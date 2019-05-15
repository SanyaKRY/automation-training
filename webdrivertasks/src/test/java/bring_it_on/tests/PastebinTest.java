package bring_it_on.tests;

import bring_it_on.pages.PageCreatePastebin;
import bring_it_on.pages.PageCreatedPastebin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PastebinTest {

    private WebDriver driver;
    PageCreatedPastebin pageCreatedPastebin;
    PageCreatePastebin pageCreatePastebin;
    String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    @BeforeTest
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageCreatedPastebin = new PageCreatePastebin(driver).openPage().fillOutForm(code, "Bash", "10 Minutes", "how to gain dominance among developers");
    }

    @Test
    public void syntaxHighlightingForBashTest(){
        Assert.assertTrue(pageCreatedPastebin.validatePageBash());
    }

    @Test
    public void pageTitleTest(){
        String title = pageCreatedPastebin.validatePageTittle();
        Assert.assertTrue(title.contains("how to gain dominance among developers"));
    }

    @Test
    public void codIsEqualsToEnteredTest(){
        Assert.assertEquals(pageCreatedPastebin.compareCode(),code.replaceAll("\\s+",""));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver=null;
    }
}
