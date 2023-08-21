package com.Amazon_cucumber_stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.Amazon_Cucumber_Project.BaseClass;
import com.Amazon_cucumber_runnerclass.Amazon_RunnerClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon_Stepdefinition extends BaseClass{

	public static WebDriver driver = Amazon_RunnerClass.driver;
	public static String expected = "";
	public static String searchvalue = "";
	public static String titletext = "";

//	@Given("user Launch The Application URL {string}")
//	public void user_launch_the_application_url(String URL) throws InterruptedException {
//
//		driver.get("https://www.amazon.in/"); //derived from feature file
//		Thread.sleep(5000);
//	}
	@Given("user Launch The Application URL")
	public void user_launch_the_application_url() throws InterruptedException {
		driver.get("https://www.amazon.in/"); //derived from feature file
		Thread.sleep(5000);
	}

	@When("user Select The Dropdown {string}")
	public void user_select_the_dropdown_value(String expected) throws InterruptedException {

		WebElement dropdown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
		Select s = new Select(dropdown);
		List<WebElement> valuelist = s.getOptions();
		ListIterator<WebElement> listi = valuelist.listIterator();

		while (listi.hasNext()) {
			WebElement next = listi.next();
			String text = next.getText();
			if (expected.equalsIgnoreCase(text)) {
				s.selectByVisibleText(expected);
				break;
			}
		}
		sleep(); //data derived from baseclass
	}

	@Then("user Search The Product {string}")
	public void user_search_the_product(String searchvalue ) throws InterruptedException {

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		user_Requirment(searchbox, searchvalue);
		
		sleep();

		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']"));
		for (int i = 1; i <= suggestions.size(); i++) {
			WebElement boxvalues = driver
					.findElement(By.xpath("//div[@class='autocomplete-results-contain']/div[" + i + "]"));
			String text = fetchText(boxvalues);//data derived from baseclass return type
			if (searchvalue.equalsIgnoreCase(text)) {
				clickOnElement(boxvalues);
				break;
			}
		}
		sleep();

	}

	@When("user Extract The FirstProduct Title")
	public void user_extract_the_first_product_title() throws InterruptedException {

		WebElement title = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2/a"));
		titletext = fetchText(title); //data derived from baseclass return type
		printText(titletext);
		sleep();

	}

	@When("Clicks The Product")
	public void clicks_the_product() throws InterruptedException {

		WebElement clicktheproduct = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2/a"));
		clickOnElement(clicktheproduct); //data derived from baseclass
				
		sleep();
	}

	@When("switch The Browser")
	public void switch_the_browser() {

		String hometab = driver.getWindowHandle();
		Set<String> multitab = driver.getWindowHandles();
		driver.switchTo().window(multitab.toArray()[1].toString());

	}

	@When("fetch The Selected Product Title")
	public void fetch_the_selected_product_title() throws InterruptedException {

		WebElement title2 = driver.findElement(By.id("productTitle"));
		String title2text = fetchText(title2); //data derived from baseclass return type

		if (title2text.equalsIgnoreCase(titletext)) {
			printText("Its Matched"); //data derived from baseclass return type
		} else {
			printText("Discrepency"); //data derived from baseclass
		}
		sleep();

	}

	@Then("click AddToCart")
	public void click_add_to_cart() throws InterruptedException {

		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		clickOnElement(addtocart); //data derived from baseclass
		sleep();
	}

	@Then("user Takes Screenshot")
	public void user_takes_screenshot() throws IOException, InterruptedException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File c = new File("C:\\Users\\Kisho\\eclipse-workspace\\Amazon_Cucumber_Project\\Screenshot\\Order.png");
		FileHandler.copy(sc, c);
		sleep();

	}

	@Then("user Compares The Title")
	public void user_compares_the_title() throws InterruptedException {

		WebElement comt = driver.findElement(By.xpath("//span[@id='sw-gtc']/child::span//a"));
		clickOnElement(comt); //data derived from baseclass
		sleep();

		WebElement title3 = driver.findElement(By.xpath("(//li[@class='a-spacing-mini']/child::span)"));
		String title3text = fetchText(title3);  //data derived from baseclass return type

		if (title3text.equalsIgnoreCase(titletext)) {
			printText("Its Matched"); //data derived from baseclass
		} else {
			printText("Discrepency"); //data derived from baseclass
		}
	}

	@Then("user Close The Page")
	public void user_close_the_page() {

//		close(); //data derived from baseclass

	}

}
