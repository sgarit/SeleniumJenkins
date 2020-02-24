package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;
	By header = By.className("private-page__title");
	By contacts = By.id("nav-secondary-contacts");
	By createDashboard = By.xpath("//span[contains(text(),'Create dashboard')]");
	By accountmenu = By.id("account-menu");
	By accountName = By.xpath("//div[@class='user-info-name']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyHomoPageHeader() {
		return driver.findElement(header).isDisplayed();
	}
	
	public boolean createDashBoardLink() {
		return driver.findElement(createDashboard).isDisplayed();
	}
	
	public String getHomePageHeaderText() {
		return driver.findElement(header).getText();
	}
	public void displayAccountMenu() {
		driver.findElement(accountmenu).click();
	}
	public String accountName() {
		return driver.findElement(accountName).getText();
	}

}
