package com.qa.hs.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver init_driver(String browserName) {
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Jars\\Selenium Projects\\LocalBadabing Project with Selenium"
					+ "\\Badabing Project\\KeywordDrivenHubSpot\\chromedriver.exe");
			
			if(prop.getProperty("headless").equals("yes")) {
				//headless mode:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);

			}else
			{
				driver = new ChromeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			
		}
		
		return driver;
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\Selenium Jars\\Selenium Projects\\LocalBadabing Project with Selenium\\Badabing Project\\KeywordDrivenHubSpot\\src"
					+ "\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
			
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	

}
