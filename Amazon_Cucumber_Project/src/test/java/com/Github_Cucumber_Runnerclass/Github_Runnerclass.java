package com.Github_Cucumber_Runnerclass;

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
@CucumberOptions (
	features = "src\\test\\java\\com\\Github_Cucumber_Feature\\Github.feature" ,
	glue = "com.Github_Cucumber_Stepd" , 
	stepNotifications = true , 
	plugin = "pretty", 
	dryRun = false,
	monochrome = true)


public class Github_Runnerclass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void launching_Browser() {
		
		ChromeOptions opt = new ChromeOptions();
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
