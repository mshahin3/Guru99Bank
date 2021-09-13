package com.guru99.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		
		String browser = prop.getProperty("browser");
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		default:
			System.out.println("Browser not defined"+browser);
			break;
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public Properties init_property() {
		
		
		
	    prop = new Properties();	
		try {
			FileInputStream fi = new FileInputStream("C:\\Users\\mshah\\javaproject\\Guru99_BankingProject\\src\\main\\java\\com\\guru99\\config\\config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	
	

}
