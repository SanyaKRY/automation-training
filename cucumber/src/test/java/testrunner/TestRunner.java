package testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import util.TestListener;

@CucumberOptions(
    features = "src/test/resources/features"
	,glue = "stepdefinitions"
	,dryRun = false
	,monochrome = false
	,plugin = {"pretty" 
	    ,"html:test-output/cucumber"
	    ,"json:test-output/cucumber-reports/cucumber.json"})

@Listeners({TestListener.class})
public class TestRunner {
	
  private TestNGCucumberRunner testNGCucumberRunner;  

  @BeforeClass(alwaysRun = true)  
  public void setUp() throws Exception {  
	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
  }  

  @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
  public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
	testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
  }  

  @DataProvider  
  public Object[][] scenarios() {  
	return testNGCucumberRunner.provideScenarios();  
  }  

  @AfterClass(alwaysRun = true)  
  public void tearDown() throws Exception {  
	testNGCucumberRunner.finish();  
  }  
	
}
