package com.Amazon_cucumber_runnerclass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//test//java//com//Amazon_Cucumber_Feature//Amazon.feature",
		glue = "com.Amazon_cucumber_stepdefinition",
		dryRun = false,
		plugin = {"pretty", "rerun:target/failed_scenarios.txt"}, 
		monochrome = true 
		)

public class Amazon_RunnerClass {
	
	public static WebDriver driver= null;
	
	@BeforeClass
	public static void launching_Browser() {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		List<String> l = new ArrayList<String>();
		l.add("start-maximized");
		l.add("disable-popup-blocking");
		opt.addArguments(l);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public static void closing_Browser() {

		driver.quit();
		
	}

}
