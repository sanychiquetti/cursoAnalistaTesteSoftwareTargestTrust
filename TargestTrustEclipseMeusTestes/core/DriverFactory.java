package com.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver driver = null; 	
	static String typeDriver = "Chrome";
	
	//Cria o driver e devolve para o teste
	public static WebDriver getDriver() {		
		if (driver == null) {
			
			if (typeDriver.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\chromedriver.exe" );
				driver = new ChromeDriver();
			}
	
			if (typeDriver.equals("Chromeheadless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1200x960");		
				
				System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
				driver = new ChromeDriver(options);
			}
			
			if (typeDriver.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver",
			 		"C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	//Mata o driver
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
