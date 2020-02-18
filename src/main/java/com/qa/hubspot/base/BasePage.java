package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("safari")) {
			
		}else {
			System.out.println("Browser not available");
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("http://www.hubspot.com");
		return driver;
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\ragin\\eclipse-workspace\\SeleniumJenkins\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		    prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("config file is missing plz check it");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("properties not loaded");
			e.printStackTrace();
		}
		return prop;
	}



}
