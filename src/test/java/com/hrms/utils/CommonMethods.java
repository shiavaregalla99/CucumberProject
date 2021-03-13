package com.hrms.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testBase.BaseClass;

public class CommonMethods {

	
	/**
	 * This method will click on the element using JSExecutor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Constants.EXPLICIT_LOAD_TIME);
		return wait;
	}
	
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
}
