package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
	
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	
	@BeforeTest
	public void setUp()  {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("homepage title is "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"title is missing");
	}
	@Test
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home Page Header is"+header);
		Assert.assertEquals(header, Constants.HOME_HEADER_TEXT,"HomePage header not present");
	}
	@Test
	public void verifyAccountnameTest() {
		homePage.displayAccountMenu();
		String accountName = homePage.accountName();
		System.out.println("Account name is"+accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
