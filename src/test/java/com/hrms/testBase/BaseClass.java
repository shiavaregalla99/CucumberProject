package com.hrms.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver setUp() {

		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
	
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			
			 driver=new ChromeDriver();
			 break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver();
			driver=new InternetExplorerDriver();
			break;	
		default:
			throw new RuntimeException("Browser is not supported");
		}

		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("URL"));
		// initialize all page objects as part of setup
		PageIntializer.initializeAll();

		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}


