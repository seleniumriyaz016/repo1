package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//tags= {"@tag1","@tag2"},
	    dryRun=false,
		monochrome=true,
		strict=true,
		features = "src\\test\\resources\\features",
		glue={"steps"},
		plugin = {
			              
				 "html:target/cucumber-html-report.html",
				 "html:target/cucumber-reports/cucumber-pretty",
			                "json:target/cucumber-reports/CucumberTestReport.json",
			                "rerun:target/cucumber-reports/rerun.txt"
			        }
				
)

public class RegRunner {

}
