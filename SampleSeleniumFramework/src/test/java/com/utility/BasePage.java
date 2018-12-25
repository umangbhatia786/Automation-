package com.utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static void setupDriver() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
			LogIT.info("Loading config file");
			prop.load(fis);
		}
		
		catch(Exception ex) {
			ex.getMessage();
		}
		
		LogIT.info("Choosing the browser");
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
		}
		
		LogIT.info("Setting up driver properties nad timeouts");
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		LogIT.info("Navigating to the given URL");
		driver.navigate().to(prop.getProperty("url"));
	}
	
	public static void closeSession() {
		driver.quit();
	}
	
	public static void switchWindow() {
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.manage().window().maximize();
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
}
