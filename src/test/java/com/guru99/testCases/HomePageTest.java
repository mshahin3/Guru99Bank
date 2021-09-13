package com.guru99.testCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99.base.BasePage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.utils.Constants;

public class HomePageTest {
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;

	
	@BeforeClass
	public void setUp() {
		
		 basepage = new BasePage();
		 prop = basepage.init_property();
		 driver = basepage.init_driver(prop);
		 loginpage = new LoginPage(driver);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle() {
		String title=homepage.HomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HomePageTitle);
	}
	
	@Test
	public void verifyHomePageHeader() {
		String header=homepage.getHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.HomepageHeader);
	}
	
	@Test
	public void verifyManagerId() {
		String managerId=homepage.getManagerID();
		System.out.println(managerId);
		Assert.assertEquals(managerId, Constants.HomePageManagerId);
	}
	
	public void verifyWelcomeMessage() {
		String welcome=homepage.getWelcomeMessage();
		System.out.println(welcome);
		Assert.assertEquals(welcome, Constants.HomepageWelcomeMessage);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
