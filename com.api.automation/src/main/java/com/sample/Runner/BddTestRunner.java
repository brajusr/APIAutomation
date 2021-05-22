package com.sample.Runner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.sample.stepdefinations.ReportUtil;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(tags={"@spacedata"},glue = {"com.sample.stepdefinations"}, features = {"src/test/features"},
plugin = {"pretty",
		 "html:target/site/cucumber-pretty",
         "json:target/cucumber.json",
         "usage:target/cucumber-usage.json",
         "junit:target/cucumber-results.xml",
         "junit:target/cucumber-json-report.json"})
public class BddTestRunner {
	
	@Test(groups = "api-testing")
    public void runCukes()
	{
		new TestNGCucumberRunner(getClass()).runCukes();
		
	}
	
	@AfterSuite
	public static void teardown()
	{
		ReportUtil.writeToJson();
		
	}

}