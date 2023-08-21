package com;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "com.Amazon_cucumber_stepdefinition",
		dryRun = false,
		plugin = {"pretty"}, 
		monochrome = true 
		)

public class Amazon_Rerunnerclass {
	
	

}
