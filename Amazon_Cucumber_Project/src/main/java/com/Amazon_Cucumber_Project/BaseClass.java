package com.Amazon_Cucumber_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

	public static WebDriver driver = null;

	public static void user_Requirment(WebElement sendkeys, String Values) {
		sendkeys.sendKeys(Values);
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static String fetchText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static void printText(String Values) {
		System.out.println(Values);
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void fetchURL(String Values) {
		driver.get(Values);
	}

	public static void dropDown() {

	}

	public static void windowHandle() {

	}

	public static void windowsHandle() {

	}

//	public static void close() {
//		driver.close();
//	}

}
