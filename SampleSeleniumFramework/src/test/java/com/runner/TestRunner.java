package com.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/Test3.feature", 
                 glue = { "com.stepDefinition" }, 
                 plugin = { "html:target/TestResults/cucumber-html-report",
		"pretty:target/TestResults/cucumber-pretty.txt", "usage:target/TestResults/cucumber-usage.json",
		"junit:target/TestResults/cucumber-results.xml","com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/TestResults/Extent-Report.html"}, 
                 dryRun = false, 
                 monochrome = true, 
                 strict = true)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(
				new File("src\\test\\resources\\extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10 " + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
