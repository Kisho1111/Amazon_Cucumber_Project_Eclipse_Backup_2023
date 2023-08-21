package com.Github_Cucumber_Stepd;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.Github_Cucumber_Runnerclass.Github_Runnerclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Github_Stepd {

	public static WebDriver driver = Github_Runnerclass.driver;
	public static String first = "";
	public static String second = "";
	public static String third = "";
	public static String fourth = "";
	public static String practise = "";
	
	@Given("user Launch The Application URL")
	public void user_launch_the_application_url() {
		
		driver.get("https://github.com/");
	}

	@When("user Opting To SignIn")
	public void user_opting_to_sign_in() throws InterruptedException {

		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		Thread.sleep(2000);
	}

	@When("user Provides LoginID & Password")
	public void user_provides_login_id_password() throws InterruptedException {

		driver.findElement(By.id("login_field")).sendKeys("kisho1111");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Kisho@1123");
		Thread.sleep(2000);

	}

	@Then("user Clicks The Login Icon")
	public void user_clicks_the_login_icon() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Thread.sleep(20000);
	}

	@When("user Extract The List Of Repositories")
	public void user_extract_the_list_of_repositories() {

		WebElement firstRep = driver
				.findElement(By.xpath("(//a[@data-hovercard-url='/Kisho1111/MakeMyTrip_Kishore/hovercard'])[2]"));
		first = firstRep.getText();

		WebElement secondRep = driver.findElement(By.xpath("(//a[@data-hovercard-url='/Kisho1111/MMT/hovercard'])[2]"));
		second = secondRep.getText();

		WebElement thirdRep = driver
				.findElement(By.xpath("(//a[@data-hovercard-url='/Kisho1111/Trail_Version/hovercard'])[2]"));
		third = thirdRep.getText();

		WebElement fourthrep = driver
				.findElement(By.xpath("(//a[@data-hovercard-url='/Kisho1111/Kishore_REST_API/hovercard'])[2]"));
		fourth = fourthrep.getText();

	}

	@When("user Gets The Name Of Repositories")
	public void user_gets_the_name_of_repositories() {

		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		System.out.println(fourth);
	}

	@When("user Creates New The New Repository")
	public void user_creates_new_the_new_repository() throws InterruptedException {

		driver.findElement(By.xpath("(//a[@class='btn btn-sm btn-primary'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("repository_name")).sendKeys("Practise");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//span[@class='dropdown-caret'])[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Your repositories']")).click();
		Thread.sleep(5000);

		WebElement rep1 = driver.findElement(By.xpath("(//a[@itemprop='name codeRepository'])[1]"));
		practise = rep1.getText();

	}

	@When("user Fetch The Name Of created Repository")
	public void user_fetch_the_name_of_created_repository() {

		System.out.println("The New Poject Name : " + practise);

	}

	@Then("user Takes The Screenshot")
	public void user_takes_the_screenshot() throws IOException, InterruptedException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File c = new File("C:\\Users\\Kisho\\eclipse-workspace\\Amazon_Cucumber_Project\\Screenshot\\GitHub.png");
		FileHandler.copy(sc, c);
		Thread.sleep(2000);

		System.out.println("Sceenshot Captured for created repositary");

	}

	@Then("user Comparing New Repository")
	public void user_comparing_new_repository() {

		if (first.contains(practise) && second.contains(practise) && third.contains(practise)
				&& fourth.contains(practise)) {
			System.out.println("It's Available with the Pervious Project");
		} else {
			System.out.println("It's Discrepancy!");
			System.out.println("Hence deleting the Project from hub!");
		}

	}

	@Then("user Deleting The Created Repository")
	public void user_deleting_the_created_repository() throws InterruptedException {

		driver.findElement(By.xpath("(//a[@itemprop='name codeRepository'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("settings-tab")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//summary[@data-view-component='true'])[9]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='verify'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='verify'])[2]")).sendKeys("Kisho1111/Practise");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='I understand the consequences, delete this repository']")).click();
		Thread.sleep(2000);

	}

	@Then("user Signing Out")
	public void user_signing_out() throws InterruptedException {

		driver.findElement(By.xpath("(//span[@class='dropdown-caret'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		Thread.sleep(2000);
	}

}
