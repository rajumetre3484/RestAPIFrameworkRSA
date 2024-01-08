package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features/placeValidationsDynamicvalueFromFeatureToTest.feature",  
                 glue= "stepDefinations",
             //    tags="@DeletePlace",
                 plugin = {"json:target/jsonReport/cucumber-report.json","html:target/cucumber-report-html/cucumber.html"}
                 
                 
		         )
                
                
                
public class TestRunner 
{
	
//117
}
