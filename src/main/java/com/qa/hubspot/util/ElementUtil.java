package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;
	

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this method is uded to create webelements on the basis of by locators
	 */

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occured while creating the web element");
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public String waitForTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
	}
	
  

public void doSendKeys(By locator, String value) {
	try {
		  getElement(locator).sendKeys(value);
		  }catch(Exception e) {
			  System.out.println("some exception occured while creating the web element");
			  System.out.println(e.getMessage());
		  }
	
}
  

}
