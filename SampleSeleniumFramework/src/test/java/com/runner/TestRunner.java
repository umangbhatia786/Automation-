package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
                 glue = { "com.stepDefinition" }, 
                 plugin = { "html:target/TestResults/cucumber-html-report",
		"pretty:target/TestResults/cucumber-pretty.txt", "usage:target/TestResults/cucumber-usage.json",
		"junit:target/TestResults/cucumber-results.xml"}, 
                 dryRun = true, 
                 monochrome = true, 
                 strict = true)
public class TestRunner {

}
